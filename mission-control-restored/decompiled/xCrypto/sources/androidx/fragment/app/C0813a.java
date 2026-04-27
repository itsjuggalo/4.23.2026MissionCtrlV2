package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.I;
import androidx.fragment.app.Q;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0813a extends Q implements I.l {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final I f7450t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7451u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7452v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7453w;

    public C0813a(I i4) {
        super(i4.u0(), i4.w0() != null ? i4.w0().f().getClassLoader() : null);
        this.f7452v = -1;
        this.f7453w = false;
        this.f7450t = i4;
    }

    @Override // androidx.fragment.app.I.l
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (I.J0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f7360i) {
            return true;
        }
        this.f7450t.h(this);
        return true;
    }

    @Override // androidx.fragment.app.Q
    public int f() {
        return o(false);
    }

    @Override // androidx.fragment.app.Q
    public int g() {
        return o(true);
    }

    @Override // androidx.fragment.app.Q
    public void h() {
        j();
        this.f7450t.c0(this, false);
    }

    @Override // androidx.fragment.app.Q
    public void i() {
        j();
        this.f7450t.c0(this, true);
    }

    @Override // androidx.fragment.app.Q
    public void k(int i4, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, String str, int i5) {
        super.k(i4, abstractComponentCallbacksC0828p, str, i5);
        abstractComponentCallbacksC0828p.mFragmentManager = this.f7450t;
    }

    @Override // androidx.fragment.app.Q
    public Q l(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        I i4 = abstractComponentCallbacksC0828p.mFragmentManager;
        if (i4 == null || i4 == this.f7450t) {
            return super.l(abstractComponentCallbacksC0828p);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + abstractComponentCallbacksC0828p.toString() + " is already attached to a FragmentManager.");
    }

    public void n(int i4) {
        if (this.f7360i) {
            if (I.J0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i4);
            }
            int size = this.f7354c.size();
            for (int i5 = 0; i5 < size; i5++) {
                Q.a aVar = (Q.a) this.f7354c.get(i5);
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = aVar.f7372b;
                if (abstractComponentCallbacksC0828p != null) {
                    abstractComponentCallbacksC0828p.mBackStackNesting += i4;
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f7372b + " to " + aVar.f7372b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public int o(boolean z4) {
        if (this.f7451u) {
            throw new IllegalStateException("commit already called");
        }
        if (I.J0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new W("FragmentManager"));
            p("  ", printWriter);
            printWriter.close();
        }
        this.f7451u = true;
        if (this.f7360i) {
            this.f7452v = this.f7450t.l();
        } else {
            this.f7452v = -1;
        }
        this.f7450t.Z(this, z4);
        return this.f7452v;
    }

    public void p(String str, PrintWriter printWriter) {
        q(str, printWriter, true);
    }

    public void q(String str, PrintWriter printWriter, boolean z4) {
        String str2;
        if (z4) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f7362k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f7452v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f7451u);
            if (this.f7359h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f7359h));
            }
            if (this.f7355d != 0 || this.f7356e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f7355d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f7356e));
            }
            if (this.f7357f != 0 || this.f7358g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f7357f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f7358g));
            }
            if (this.f7363l != 0 || this.f7364m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f7363l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f7364m);
            }
            if (this.f7365n != 0 || this.f7366o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f7365n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f7366o);
            }
        }
        if (this.f7354c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f7354c.size();
        for (int i4 = 0; i4 < size; i4++) {
            Q.a aVar = (Q.a) this.f7354c.get(i4);
            switch (aVar.f7371a) {
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
                    str2 = "cmd=" + aVar.f7371a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i4);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f7372b);
            if (z4) {
                if (aVar.f7374d != 0 || aVar.f7375e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f7374d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f7375e));
                }
                if (aVar.f7376f != 0 || aVar.f7377g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f7376f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f7377g));
                }
            }
        }
    }

    public void r() {
        int size = this.f7354c.size();
        for (int i4 = 0; i4 < size; i4++) {
            Q.a aVar = (Q.a) this.f7354c.get(i4);
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = aVar.f7372b;
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.mBeingSaved = this.f7453w;
                abstractComponentCallbacksC0828p.setPopDirection(false);
                abstractComponentCallbacksC0828p.setNextTransition(this.f7359h);
                abstractComponentCallbacksC0828p.setSharedElementNames(this.f7367p, this.f7368q);
            }
            switch (aVar.f7371a) {
                case 1:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.n1(abstractComponentCallbacksC0828p, false);
                    this.f7450t.i(abstractComponentCallbacksC0828p);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f7371a);
                case 3:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.f1(abstractComponentCallbacksC0828p);
                    break;
                case 4:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.G0(abstractComponentCallbacksC0828p);
                    break;
                case 5:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.n1(abstractComponentCallbacksC0828p, false);
                    this.f7450t.r1(abstractComponentCallbacksC0828p);
                    break;
                case 6:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.x(abstractComponentCallbacksC0828p);
                    break;
                case 7:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.n1(abstractComponentCallbacksC0828p, false);
                    this.f7450t.n(abstractComponentCallbacksC0828p);
                    break;
                case 8:
                    this.f7450t.p1(abstractComponentCallbacksC0828p);
                    break;
                case 9:
                    this.f7450t.p1(null);
                    break;
                case 10:
                    this.f7450t.o1(abstractComponentCallbacksC0828p, aVar.f7379i);
                    break;
            }
        }
    }

    public void s() {
        for (int size = this.f7354c.size() - 1; size >= 0; size--) {
            Q.a aVar = (Q.a) this.f7354c.get(size);
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = aVar.f7372b;
            if (abstractComponentCallbacksC0828p != null) {
                abstractComponentCallbacksC0828p.mBeingSaved = this.f7453w;
                abstractComponentCallbacksC0828p.setPopDirection(true);
                abstractComponentCallbacksC0828p.setNextTransition(I.k1(this.f7359h));
                abstractComponentCallbacksC0828p.setSharedElementNames(this.f7368q, this.f7367p);
            }
            switch (aVar.f7371a) {
                case 1:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.n1(abstractComponentCallbacksC0828p, true);
                    this.f7450t.f1(abstractComponentCallbacksC0828p);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f7371a);
                case 3:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.i(abstractComponentCallbacksC0828p);
                    break;
                case 4:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.r1(abstractComponentCallbacksC0828p);
                    break;
                case 5:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.n1(abstractComponentCallbacksC0828p, true);
                    this.f7450t.G0(abstractComponentCallbacksC0828p);
                    break;
                case 6:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.n(abstractComponentCallbacksC0828p);
                    break;
                case 7:
                    abstractComponentCallbacksC0828p.setAnimations(aVar.f7374d, aVar.f7375e, aVar.f7376f, aVar.f7377g);
                    this.f7450t.n1(abstractComponentCallbacksC0828p, true);
                    this.f7450t.x(abstractComponentCallbacksC0828p);
                    break;
                case 8:
                    this.f7450t.p1(null);
                    break;
                case 9:
                    this.f7450t.p1(abstractComponentCallbacksC0828p);
                    break;
                case 10:
                    this.f7450t.o1(abstractComponentCallbacksC0828p, aVar.f7378h);
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.fragment.app.AbstractComponentCallbacksC0828p t(java.util.ArrayList r17, androidx.fragment.app.AbstractComponentCallbacksC0828p r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList r5 = r0.f7354c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList r5 = r0.f7354c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.Q$a r5 = (androidx.fragment.app.Q.a) r5
            int r6 = r5.f7371a
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
            java.util.ArrayList r6 = r0.f7354c
            androidx.fragment.app.Q$a r8 = new androidx.fragment.app.Q$a
            r8.<init>(r11, r3, r7)
            r6.add(r4, r8)
            r5.f7373c = r7
            int r4 = r4 + 1
            androidx.fragment.app.p r3 = r5.f7372b
            goto Lbb
        L43:
            androidx.fragment.app.p r6 = r5.f7372b
            r1.remove(r6)
            androidx.fragment.app.p r5 = r5.f7372b
            if (r5 != r3) goto Lbb
            java.util.ArrayList r3 = r0.f7354c
            androidx.fragment.app.Q$a r6 = new androidx.fragment.app.Q$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lbb
        L5a:
            androidx.fragment.app.p r6 = r5.f7372b
            int r8 = r6.mContainerId
            int r12 = r1.size()
            int r12 = r12 - r7
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.p r14 = (androidx.fragment.app.AbstractComponentCallbacksC0828p) r14
            int r15 = r14.mContainerId
            if (r15 != r8) goto La1
            if (r14 != r6) goto L74
            r13 = r7
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList r3 = r0.f7354c
            androidx.fragment.app.Q$a r15 = new androidx.fragment.app.Q$a
            r15.<init>(r11, r14, r7)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L83:
            androidx.fragment.app.Q$a r15 = new androidx.fragment.app.Q$a
            r15.<init>(r10, r14, r7)
            int r2 = r5.f7374d
            r15.f7374d = r2
            int r2 = r5.f7376f
            r15.f7376f = r2
            int r2 = r5.f7375e
            r15.f7375e = r2
            int r2 = r5.f7377g
            r15.f7377g = r2
            java.util.ArrayList r2 = r0.f7354c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList r2 = r0.f7354c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.f7371a = r7
            r5.f7373c = r7
            r1.add(r6)
            goto Lbb
        Lb6:
            androidx.fragment.app.p r2 = r5.f7372b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r7
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0813a.t(java.util.ArrayList, androidx.fragment.app.p):androidx.fragment.app.p");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f7452v >= 0) {
            sb.append(" #");
            sb.append(this.f7452v);
        }
        if (this.f7362k != null) {
            sb.append(" ");
            sb.append(this.f7362k);
        }
        sb.append("}");
        return sb.toString();
    }

    public String u() {
        return this.f7362k;
    }

    public void v() {
        if (this.f7370s != null) {
            for (int i4 = 0; i4 < this.f7370s.size(); i4++) {
                ((Runnable) this.f7370s.get(i4)).run();
            }
            this.f7370s = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.fragment.app.AbstractComponentCallbacksC0828p w(java.util.ArrayList r6, androidx.fragment.app.AbstractComponentCallbacksC0828p r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.f7354c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList r2 = r5.f7354c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.Q$a r2 = (androidx.fragment.app.Q.a) r2
            int r3 = r2.f7371a
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
            androidx.lifecycle.i$b r3 = r2.f7378h
            r2.f7379i = r3
            goto L32
        L22:
            androidx.fragment.app.p r7 = r2.f7372b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.p r2 = r2.f7372b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.p r2 = r2.f7372b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0813a.w(java.util.ArrayList, androidx.fragment.app.p):androidx.fragment.app.p");
    }
}
