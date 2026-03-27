package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8411a;

    public interface a {
        void a(a.b bVar);

        a.b b(int i7, int i8, int i9, Object obj);
    }

    public h(a aVar) {
        this.f8411a = aVar;
    }

    public final int a(List list) {
        boolean z7 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((a.b) list.get(size)).f8283a != 8) {
                z7 = true;
            } else if (z7) {
                return size;
            }
        }
        return -1;
    }

    public void b(List list) {
        while (true) {
            int iA = a(list);
            if (iA == -1) {
                return;
            } else {
                d(list, iA, iA + 1);
            }
        }
    }

    public final void c(List list, int i7, a.b bVar, int i8, a.b bVar2) {
        int i9 = bVar.f8286d;
        int i10 = bVar2.f8284b;
        int i11 = i9 < i10 ? -1 : 0;
        int i12 = bVar.f8284b;
        if (i12 < i10) {
            i11++;
        }
        if (i10 <= i12) {
            bVar.f8284b = i12 + bVar2.f8286d;
        }
        int i13 = bVar2.f8284b;
        if (i13 <= i9) {
            bVar.f8286d = i9 + bVar2.f8286d;
        }
        bVar2.f8284b = i13 + i11;
        list.set(i7, bVar2);
        list.set(i8, bVar);
    }

    public final void d(List list, int i7, int i8) {
        a.b bVar = (a.b) list.get(i7);
        a.b bVar2 = (a.b) list.get(i8);
        int i9 = bVar2.f8283a;
        if (i9 == 1) {
            c(list, i7, bVar, i8, bVar2);
        } else if (i9 == 2) {
            e(list, i7, bVar, i8, bVar2);
        } else {
            if (i9 != 4) {
                return;
            }
            f(list, i7, bVar, i8, bVar2);
        }
    }

    public void e(List list, int i7, a.b bVar, int i8, a.b bVar2) {
        boolean z7;
        int i9 = bVar.f8284b;
        int i10 = bVar.f8286d;
        boolean z8 = false;
        if (i9 < i10) {
            if (bVar2.f8284b == i9 && bVar2.f8286d == i10 - i9) {
                z7 = false;
                z8 = true;
            } else {
                z7 = false;
            }
        } else if (bVar2.f8284b == i10 + 1 && bVar2.f8286d == i9 - i10) {
            z7 = true;
            z8 = true;
        } else {
            z7 = true;
        }
        int i11 = bVar2.f8284b;
        if (i10 < i11) {
            bVar2.f8284b = i11 - 1;
        } else {
            int i12 = bVar2.f8286d;
            if (i10 < i11 + i12) {
                bVar2.f8286d = i12 - 1;
                bVar.f8283a = 2;
                bVar.f8286d = 1;
                if (bVar2.f8286d == 0) {
                    list.remove(i8);
                    this.f8411a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i13 = bVar.f8284b;
        int i14 = bVar2.f8284b;
        a.b bVarB = null;
        if (i13 <= i14) {
            bVar2.f8284b = i14 + 1;
        } else {
            int i15 = bVar2.f8286d;
            if (i13 < i14 + i15) {
                bVarB = this.f8411a.b(2, i13 + 1, (i14 + i15) - i13, null);
                bVar2.f8286d = bVar.f8284b - bVar2.f8284b;
            }
        }
        if (z8) {
            list.set(i7, bVar2);
            list.remove(i8);
            this.f8411a.a(bVar);
            return;
        }
        if (z7) {
            if (bVarB != null) {
                int i16 = bVar.f8284b;
                if (i16 > bVarB.f8284b) {
                    bVar.f8284b = i16 - bVarB.f8286d;
                }
                int i17 = bVar.f8286d;
                if (i17 > bVarB.f8284b) {
                    bVar.f8286d = i17 - bVarB.f8286d;
                }
            }
            int i18 = bVar.f8284b;
            if (i18 > bVar2.f8284b) {
                bVar.f8284b = i18 - bVar2.f8286d;
            }
            int i19 = bVar.f8286d;
            if (i19 > bVar2.f8284b) {
                bVar.f8286d = i19 - bVar2.f8286d;
            }
        } else {
            if (bVarB != null) {
                int i20 = bVar.f8284b;
                if (i20 >= bVarB.f8284b) {
                    bVar.f8284b = i20 - bVarB.f8286d;
                }
                int i21 = bVar.f8286d;
                if (i21 >= bVarB.f8284b) {
                    bVar.f8286d = i21 - bVarB.f8286d;
                }
            }
            int i22 = bVar.f8284b;
            if (i22 >= bVar2.f8284b) {
                bVar.f8284b = i22 - bVar2.f8286d;
            }
            int i23 = bVar.f8286d;
            if (i23 >= bVar2.f8284b) {
                bVar.f8286d = i23 - bVar2.f8286d;
            }
        }
        list.set(i7, bVar2);
        if (bVar.f8284b != bVar.f8286d) {
            list.set(i8, bVar);
        } else {
            list.remove(i8);
        }
        if (bVarB != null) {
            list.add(i7, bVarB);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.util.List r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f8286d
            int r1 = r13.f8284b
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.f8284b = r1
            goto L20
        Ld:
            int r5 = r13.f8286d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.f8286d = r5
            androidx.recyclerview.widget.h$a r0 = r8.f8411a
            int r1 = r11.f8284b
            java.lang.Object r5 = r13.f8285c
            androidx.recyclerview.widget.a$b r0 = r0.b(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.f8284b
            int r5 = r13.f8284b
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.f8284b = r5
            goto L41
        L2b:
            int r6 = r13.f8286d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.h$a r4 = r8.f8411a
            int r1 = r1 + r3
            java.lang.Object r3 = r13.f8285c
            androidx.recyclerview.widget.a$b r4 = r4.b(r2, r1, r5, r3)
            int r1 = r13.f8286d
            int r1 = r1 - r5
            r13.f8286d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f8286d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.h$a r11 = r8.f8411a
            r11.a(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.h.f(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
