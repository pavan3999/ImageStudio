package com.redlee90.imagekitchenforandroid.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.redlee90.imagekitchenforandroid.R;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends ArrayAdapter<File> {
    private Context b;
    private List<File> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f681e;

    public a(Context context, List<File> list, HashMap<String, String> map, HashMap<String, String> map2) {
        super(context, 0, list);
        this.b = context;
        this.c = list;
        this.f680d = map;
        this.f681e = map2;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Resources resources;
        int i2;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_main_list, viewGroup, false);
        }
        File file = this.c.get(i);
        ((TextView) view.findViewById(R.id.tv_exportdialog_filename)).setText(file.getName());
        ((TextView) view.findViewById(R.id.file_permission)).setText(this.f680d.get(file.getName()));
        ((TextView) view.findViewById(R.id.file_symlink)).setText(this.f681e.get(file.getName()));
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_exportdialog_icon);
        if (file.isDirectory()) {
            resources = this.b.getResources();
            i2 = R.drawable.ic_folder_black_48dp;
        } else if (file.getName().endsWith("apk")) {
            resources = this.b.getResources();
            i2 = R.drawable.ic_android_black_48dp;
        } else if (file.getName().endsWith("rc") || file.getName().endsWith("prop")) {
            resources = this.b.getResources();
            i2 = R.drawable.ic_description_black_48dp;
        } else if (file.getName().endsWith("png") || file.getName().endsWith("jpg") || file.getName().endsWith("jpeg")) {
            resources = this.b.getResources();
            i2 = R.drawable.ic_image_black_48dp;
        } else if (file.getName().equals("init") || file.getName().equals("charger") || file.getName().equals("sepolicy") || file.getParentFile().getName().equals("sbin") || file.getParentFile().getName().equals("supersu")) {
            resources = this.b.getResources();
            i2 = R.drawable.ic_binary_file_black_48dp;
        } else {
            resources = this.b.getResources();
            i2 = R.drawable.ic_insert_drive_file_black_48dp;
        }
        imageView.setImageDrawable(resources.getDrawable(i2));
        return view;
    }
}
