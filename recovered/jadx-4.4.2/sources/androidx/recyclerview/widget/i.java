package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class i {
    final a a;

    interface a {
        androidx.recyclerview.widget.a.b a(int i, int i2, int i3, Object obj);

        void b(androidx.recyclerview.widget.a.b bVar);
    }

    i(a aVar) {
        this.a = aVar;
    }

    private int a(List<androidx.recyclerview.widget.a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<androidx.recyclerview.widget.a.b> list, int i, androidx.recyclerview.widget.a.b bVar, int i2, androidx.recyclerview.widget.a.b bVar2) {
        int i3 = bVar.f443d < bVar2.b ? -1 : 0;
        if (bVar.b < bVar2.b) {
            i3++;
        }
        int i4 = bVar2.b;
        int i5 = bVar.b;
        if (i4 <= i5) {
            bVar.b = i5 + bVar2.f443d;
        }
        int i6 = bVar2.b;
        int i7 = bVar.f443d;
        if (i6 <= i7) {
            bVar.f443d = i7 + bVar2.f443d;
        }
        bVar2.b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    private void d(List<androidx.recyclerview.widget.a.b> list, int i, int i2) {
        androidx.recyclerview.widget.a.b bVar = list.get(i);
        androidx.recyclerview.widget.a.b bVar2 = list.get(i2);
        int i3 = bVar2.a;
        if (i3 == 1) {
            c(list, i, bVar, i2, bVar2);
        } else if (i3 == 2) {
            e(list, i, bVar, i2, bVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            f(list, i, bVar, i2, bVar2);
        }
    }

    void b(List<androidx.recyclerview.widget.a.b> list) {
        while (true) {
            int iA = a(list);
            if (iA == -1) {
                return;
            } else {
                d(list, iA, iA + 1);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00ca A[PHI: r0
      0x00ca: PHI (r0v12 int) = (r0v6 int), (r0v16 int) binds: [B:59:0x00c8, B:46:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    void e(List<androidx.recyclerview.widget.a.b> list, int i, androidx.recyclerview.widget.a.b bVar, int i2, androidx.recyclerview.widget.a.b bVar2) {
        boolean z;
        int i3;
        int i4 = bVar.b;
        int i5 = bVar.f443d;
        boolean z2 = false;
        int i6 = bVar2.b;
        if (i4 < i5) {
            if (i6 == i4 && bVar2.f443d == i5 - i4) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (i6 == i5 + 1 && bVar2.f443d == i4 - i5) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i7 = bVar.f443d;
        int i8 = bVar2.b;
        if (i7 < i8) {
            bVar2.b = i8 - 1;
        } else {
            int i9 = bVar2.f443d;
            if (i7 < i8 + i9) {
                bVar2.f443d = i9 - 1;
                bVar.a = 2;
                bVar.f443d = 1;
                if (bVar2.f443d == 0) {
                    list.remove(i2);
                    this.a.b(bVar2);
                    return;
                }
                return;
            }
        }
        int i10 = bVar.b;
        int i11 = bVar2.b;
        androidx.recyclerview.widget.a.b bVarA = null;
        if (i10 <= i11) {
            bVar2.b = i11 + 1;
        } else {
            int i12 = bVar2.f443d;
            if (i10 < i11 + i12) {
                bVarA = this.a.a(2, i10 + 1, (i11 + i12) - i10, null);
                bVar2.f443d = bVar.b - bVar2.b;
            }
        }
        if (z2) {
            list.set(i, bVar2);
            list.remove(i2);
            this.a.b(bVar);
            return;
        }
        if (z) {
            if (bVarA != null) {
                int i13 = bVar.b;
                if (i13 > bVarA.b) {
                    bVar.b = i13 - bVarA.f443d;
                }
                int i14 = bVar.f443d;
                if (i14 > bVarA.b) {
                    bVar.f443d = i14 - bVarA.f443d;
                }
            }
            int i15 = bVar.b;
            if (i15 > bVar2.b) {
                bVar.b = i15 - bVar2.f443d;
            }
            i3 = bVar.f443d;
            if (i3 > bVar2.b) {
                bVar.f443d = i3 - bVar2.f443d;
            }
        } else {
            if (bVarA != null) {
                int i16 = bVar.b;
                if (i16 >= bVarA.b) {
                    bVar.b = i16 - bVarA.f443d;
                }
                int i17 = bVar.f443d;
                if (i17 >= bVarA.b) {
                    bVar.f443d = i17 - bVarA.f443d;
                }
            }
            int i18 = bVar.b;
            if (i18 >= bVar2.b) {
                bVar.b = i18 - bVar2.f443d;
            }
            i3 = bVar.f443d;
            if (i3 >= bVar2.b) {
                bVar.f443d = i3 - bVar2.f443d;
            }
        }
        list.set(i, bVar2);
        if (bVar.b != bVar.f443d) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVarA != null) {
            list.add(i, bVarA);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    void f(List<androidx.recyclerview.widget.a.b> list, int i, androidx.recyclerview.widget.a.b bVar, int i2, androidx.recyclerview.widget.a.b bVar2) {
        androidx.recyclerview.widget.a.b bVarA;
        int i3;
        int i4;
        int i5;
        int i6 = bVar.f443d;
        int i7 = bVar2.b;
        androidx.recyclerview.widget.a.b bVarA2 = null;
        if (i6 >= i7) {
            int i8 = bVar2.f443d;
            if (i6 < i7 + i8) {
                bVar2.f443d = i8 - 1;
                bVarA = this.a.a(4, bVar.b, 1, bVar2.c);
            }
            i3 = bVar.b;
            i4 = bVar2.b;
            if (i3 <= i4) {
                bVar2.b = i4 + 1;
            } else {
                i5 = bVar2.f443d;
                if (i3 < i4 + i5) {
                    int i9 = (i4 + i5) - i3;
                    bVarA2 = this.a.a(4, i3 + 1, i9, bVar2.c);
                    bVar2.f443d -= i9;
                }
            }
            list.set(i2, bVar);
            if (bVar2.f443d > 0) {
                list.set(i, bVar2);
            } else {
                list.remove(i);
                this.a.b(bVar2);
            }
            if (bVarA != null) {
                list.add(i, bVarA);
            }
            if (bVarA2 != null) {
                list.add(i, bVarA2);
            }
        }
        bVar2.b = i7 - 1;
        bVarA = null;
        i3 = bVar.b;
        i4 = bVar2.b;
        if (i3 <= i4) {
            bVar2.b = i4 + 1;
        } else {
            i5 = bVar2.f443d;
            if (i3 < i4 + i5) {
                int i10 = (i4 + i5) - i3;
                bVarA2 = this.a.a(4, i3 + 1, i10, bVar2.c);
                bVar2.f443d -= i10;
            }
        }
        list.set(i2, bVar);
        if (bVar2.f443d > 0) {
            list.set(i, bVar2);
        } else {
            list.remove(i);
            this.a.b(bVar2);
        }
        if (bVarA != null) {
            list.add(i, bVarA);
        }
        if (bVarA2 != null) {
            list.add(i, bVarA2);
        }
    }
}
