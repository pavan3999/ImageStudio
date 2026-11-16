package com.redlee90.imagekitchenforandroid.engine;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/** Installs the versioned 4.5 engine scripts into the app-private data directory. */
public final class EngineInstaller {
    private static final String[] SCRIPTS = {
        "unpackimg.sh", "repackimg.sh", "mount_ext4.sh", "unmount_ext4.sh"
    };

    private EngineInstaller() { }

    public static void install(Context context, File targetDirectory) throws IOException {
        if (!targetDirectory.exists() && !targetDirectory.mkdirs()) {
            throw new IOException("Cannot create engine directory: " + targetDirectory);
        }
        for (String script : SCRIPTS) {
            File target = new File(targetDirectory, script);
            // 4.4.2 created these names as symlinks into nativeLibraryDir.
            // Delete the link itself before writing; never follow it and truncate a .so.
            if (target.exists() || isSymlink(target)) {
                if (!target.delete()) throw new IOException("Cannot replace old engine link: " + target);
            }
            try (InputStream in = context.getAssets().open("engine/" + script);
                 FileOutputStream out = new FileOutputStream(target, false)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = in.read(buffer)) != -1) out.write(buffer, 0, count);
                out.getFD().sync();
            }
            if (!target.setExecutable(true, true) && !target.canExecute()) {
                throw new IOException("Cannot mark engine script executable: " + target);
            }
        }
        // Optional MagiskBoot payload: app/src/main/assets/engine/magiskboot
        // from a pinned official ARM64 Magisk release. It is not bundled here.
        boolean hasMagiskBoot = false;
        for (String asset : context.getAssets().list("engine")) {
            if ("magiskboot".equals(asset)) hasMagiskBoot = true;
        }
        if (hasMagiskBoot) {
            File magiskboot = new File(targetDirectory, "magiskboot");
            if ((magiskboot.exists() || isSymlink(magiskboot)) && !magiskboot.delete()) {
                throw new IOException("Cannot replace existing MagiskBoot binary");
            }
            try (InputStream in = context.getAssets().open("engine/magiskboot");
                 FileOutputStream out = new FileOutputStream(magiskboot, false)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = in.read(buffer)) != -1) out.write(buffer, 0, count);
                out.getFD().sync();
            }
            if (!magiskboot.setExecutable(true, true) && !magiskboot.canExecute()) {
                throw new IOException("Cannot mark MagiskBoot executable");
            }
        }
    }

    private static boolean isSymlink(File file) {
        try {
            return !file.getCanonicalFile().equals(file.getAbsoluteFile());
        } catch (IOException ignored) {
            return false;
        }
    }
}
