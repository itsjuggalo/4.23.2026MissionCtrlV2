package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.i0;
import androidx.fragment.app.q0;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends q0 implements i0.l {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final i0 f2020t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2021u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2022v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2023w;

    public a(i0 i0Var) {
        super(i0Var.u0(), i0Var.w0() != null ? i0Var.w0().f().getClassLoader() : null);
        this.f2022v = -1;
        this.f2023w = false;
        this.f2020t = i0Var;
    }

    @Override // androidx.fragment.app.i0.l
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (i0.J0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2276i) {
            return true;
        }
        this.f2020t.h(this);
        return true;
    }

    @Override // androidx.fragment.app.q0
    public int f() {
        return o(false);
    }

    @Override // androidx.fragment.app.q0
    public int g() {
        return o(true);
    }

    @Override // androidx.fragment.app.q0
    public void h() {
        j();
        this.f2020t.c0(this, false);
    }

    @Override // androidx.fragment.app.q0
    public void i() {
        j();
        this.f2020t.c0(this, true);
    }

    @Override // androidx.fragment.app.q0
    public void k(int i10, p pVar, String str, int i11) {
        super.k(i10, pVar, str, i11);
        pVar.mFragmentManager = this.f2020t;
    }

    @Override // androidx.fragment.app.q0
    public q0 l(p pVar) {
        i0 i0Var = pVar.mFragmentManager;
        if (i0Var == null || i0Var == this.f2020t) {
            return super.l(pVar);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + pVar.toString() + " is already attached to a FragmentManager.");
    }

    public void n(int i10) {
        if (this.f2276i) {
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            int size = this.f2270c.size();
            for (int i11 = 0; i11 < size; i11++) {
                q0.a aVar = (q0.a) this.f2270c.get(i11);
                p pVar = aVar.f2288b;
                if (pVar != null) {
                    pVar.mBackStackNesting += i10;
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f2288b + " to " + aVar.f2288b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public int o(boolean z10) {
        if (this.f2021u) {
            throw new IllegalStateException("commit already called");
        }
        if (i0.J0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
            p("  ", printWriter);
            printWriter.close();
        }
        this.f2021u = true;
        if (this.f2276i) {
            this.f2022v = this.f2020t.l();
        } else {
            this.f2022v = -1;
        }
        this.f2020t.Z(this, z10);
        return this.f2022v;
    }

    public void p(String str, PrintWriter printWriter) {
        q(str, printWriter, true);
    }

    public void q(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2278k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2022v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2021u);
            if (this.f2275h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2275h));
            }
            if (this.f2271d != 0 || this.f2272e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2271d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2272e));
            }
            if (this.f2273f != 0 || this.f2274g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2273f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2274g));
            }
            if (this.f2279l != 0 || this.f2280m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2279l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2280m);
            }
            if (this.f2281n != 0 || this.f2282o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2281n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2282o);
            }
        }
        if (this.f2270c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f2270c.size();
        for (int i10 = 0; i10 < size; i10++) {
            q0.a aVar = (q0.a) this.f2270c.get(i10);
            switch (aVar.f2287a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f2287a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f2288b);
            if (z10) {
                if (aVar.f2290d != 0 || aVar.f2291e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f2290d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f2291e));
                }
                if (aVar.f2292f != 0 || aVar.f2293g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f2292f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f2293g));
                }
            }
        }
    }

    public void r() {
        int size = this.f2270c.size();
        for (int i10 = 0; i10 < size; i10++) {
            q0.a aVar = (q0.a) this.f2270c.get(i10);
            p pVar = aVar.f2288b;
            if (pVar != null) {
                pVar.mBeingSaved = this.f2023w;
                pVar.setPopDirection(false);
                pVar.setNextTransition(this.f2275h);
                pVar.setSharedElementNames(this.f2283p, this.f2284q);
            }
            switch (aVar.f2287a) {
                case 1:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.n1(pVar, false);
                    this.f2020t.i(pVar);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2287a);
                case 3:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.f1(pVar);
                    break;
                case 4:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.G0(pVar);
                    break;
                case 5:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.n1(pVar, false);
                    this.f2020t.r1(pVar);
                    break;
                case 6:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.x(pVar);
                    break;
                case 7:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.n1(pVar, false);
                    this.f2020t.n(pVar);
                    break;
                case 8:
                    this.f2020t.p1(pVar);
                    break;
                case 9:
                    this.f2020t.p1(null);
                    break;
                case 10:
                    this.f2020t.o1(pVar, aVar.f2295i);
                    break;
            }
        }
    }

    public void s() {
        for (int size = this.f2270c.size() - 1; size >= 0; size--) {
            q0.a aVar = (q0.a) this.f2270c.get(size);
            p pVar = aVar.f2288b;
            if (pVar != null) {
                pVar.mBeingSaved = this.f2023w;
                pVar.setPopDirection(true);
                pVar.setNextTransition(i0.k1(this.f2275h));
                pVar.setSharedElementNames(this.f2284q, this.f2283p);
            }
            switch (aVar.f2287a) {
                case 1:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.n1(pVar, true);
                    this.f2020t.f1(pVar);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2287a);
                case 3:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.i(pVar);
                    break;
                case 4:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.r1(pVar);
                    break;
                case 5:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.n1(pVar, true);
                    this.f2020t.G0(pVar);
                    break;
                case 6:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.n(pVar);
                    break;
                case 7:
                    pVar.setAnimations(aVar.f2290d, aVar.f2291e, aVar.f2292f, aVar.f2293g);
                    this.f2020t.n1(pVar, true);
                    this.f2020t.x(pVar);
                    break;
                case 8:
                    this.f2020t.p1(null);
                    break;
                case 9:
                    this.f2020t.p1(pVar);
                    break;
                case 10:
                    this.f2020t.o1(pVar, aVar.f2294h);
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.fragment.app.p t(java.util.ArrayList r17, androidx.fragment.app.p r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList r5 = r0.f2270c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList r5 = r0.f2270c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.q0$a r5 = (androidx.fragment.app.q0.a) r5
            int r6 = r5.f2287a
            r7 = 1
            if (r6 == r7) goto Lb6
            r8 = 2
            r9 = 0
            r10 = 3
            r11 = 9
            if (r6 == r8) goto L5a
            if (r6 == r10) goto L43
            r8 = 6
            if (r6 == r8) goto L43
            r8 = 7
            if (r6 == r8) goto Lb6
            r8 = 8
            if (r6 == r8) goto L31
            goto Lbb
        L31:
            java.util.ArrayList r6 = r0.f2270c
            androidx.fragment.app.q0$a r8 = new androidx.fragment.app.q0$a
            r8.<init>(r11, r3, r7)
            r6.add(r4, r8)
            r5.f2289c = r7
            int r4 = r4 + 1
            androidx.fragment.app.p r3 = r5.f2288b
            goto Lbb
        L43:
            androidx.fragment.app.p r6 = r5.f2288b
            r1.remove(r6)
            androidx.fragment.app.p r5 = r5.f2288b
            if (r5 != r3) goto Lbb
            java.util.ArrayList r3 = r0.f2270c
            androidx.fragment.app.q0$a r6 = new androidx.fragment.app.q0$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lbb
        L5a:
            androidx.fragment.app.p r6 = r5.f2288b
            int r8 = r6.mContainerId
            int r12 = r1.size()
            int r12 = r12 - r7
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.p r14 = (androidx.fragment.app.p) r14
            int r15 = r14.mContainerId
            if (r15 != r8) goto La1
            if (r14 != r6) goto L74
            r13 = r7
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList r3 = r0.f2270c
            androidx.fragment.app.q0$a r15 = new androidx.fragment.app.q0$a
            r15.<init>(r11, r14, r7)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L83:
            androidx.fragment.app.q0$a r15 = new androidx.fragment.app.q0$a
            r15.<init>(r10, r14, r7)
            int r2 = r5.f2290d
            r15.f2290d = r2
            int r2 = r5.f2292f
            r15.f2292f = r2
            int r2 = r5.f2291e
            r15.f2291e = r2
            int r2 = r5.f2293g
            r15.f2293g = r2
            java.util.ArrayList r2 = r0.f2270c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList r2 = r0.f2270c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.f2287a = r7
            r5.f2289c = r7
            r1.add(r6)
            goto Lbb
        Lb6:
            androidx.fragment.app.p r2 = r5.f2288b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r7
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.t(java.util.ArrayList, androidx.fragment.app.p):androidx.fragment.app.p");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2022v >= 0) {
            sb2.append(" #");
            sb2.append(this.f2022v);
        }
        if (this.f2278k != null) {
            sb2.append(" ");
            sb2.append(this.f2278k);
        }
        sb2.append("}");
        return sb2.toString();
    }

    public String u() {
        return this.f2278k;
    }

    public void v() {
        if (this.f2286s != null) {
            for (int i10 = 0; i10 < this.f2286s.size(); i10++) {
                ((Runnable) this.f2286s.get(i10)).run();
            }
            this.f2286s = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.fragment.app.p w(java.util.ArrayList r6, androidx.fragment.app.p r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.f2270c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList r2 = r5.f2270c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.q0$a r2 = (androidx.fragment.app.q0.a) r2
            int r3 = r2.f2287a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.i$b r3 = r2.f2294h
            r2.f2295i = r3
            goto L32
        L22:
            androidx.fragment.app.p r7 = r2.f2288b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.p r2 = r2.f2288b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.p r2 = r2.f2288b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.w(java.util.ArrayList, androidx.fragment.app.p):androidx.fragment.app.p");
    }
}
