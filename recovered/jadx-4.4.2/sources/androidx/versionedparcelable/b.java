package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseIntArray f483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Parcel f484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f486g;
    private final String h;
    private int i;
    private int j;
    private int k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new d.d.a(), new d.d.a(), new d.d.a());
    }

    private b(Parcel parcel, int i, int i2, String str, d.d.a<String, Method> aVar, d.d.a<String, Method> aVar2, d.d.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f483d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.f484e = parcel;
        this.f485f = i;
        this.f486g = i2;
        this.j = i;
        this.h = str;
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f484e.writeInt(-1);
        } else {
            this.f484e.writeInt(bArr.length);
            this.f484e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f484e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i) {
        this.f484e.writeInt(i);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f484e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f484e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i = this.i;
        if (i >= 0) {
            int i2 = this.f483d.get(i);
            int iDataPosition = this.f484e.dataPosition();
            this.f484e.setDataPosition(i2);
            this.f484e.writeInt(iDataPosition - i2);
            this.f484e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f484e;
        int iDataPosition = parcel.dataPosition();
        int i = this.j;
        if (i == this.f485f) {
            i = this.f486g;
        }
        return new b(parcel, iDataPosition, i, this.h + "  ", this.a, this.b, this.c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f484e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int i = this.f484e.readInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f484e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f484e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i) {
        while (this.j < this.f486g) {
            int i2 = this.k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f484e.setDataPosition(this.j);
            int i3 = this.f484e.readInt();
            this.k = this.f484e.readInt();
            this.j += i3;
        }
        return this.k == i;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f484e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.f484e.readParcelable(b.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f484e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i) {
        a();
        this.i = i;
        this.f483d.put(i, this.f484e.dataPosition());
        E(0);
        E(i);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z) {
        this.f484e.writeInt(z ? 1 : 0);
    }
}
