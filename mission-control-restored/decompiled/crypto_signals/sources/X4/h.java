package X4;

import O.C0174c;
import R4.l;
import a5.AbstractC0317y;
import android.util.Log;
import kotlin.jvm.internal.j;
import s4.C1060g;
import s4.S;
import s4.W;
import s4.a0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3527a;

    public /* synthetic */ h(int i) {
        this.f3527a = i;
    }

    @Override // R4.l
    public final Object invoke(Object it) {
        switch (this.f3527a) {
            case 0:
                j.e(it, "it");
                break;
            case 1:
                I4.g gVar = (I4.g) it;
                if (gVar instanceof AbstractC0317y) {
                }
                break;
            case 2:
                C0174c ex = (C0174c) it;
                j.e(ex, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session configs DataStore", ex);
                break;
            case 3:
                int i = C1060g.e;
                break;
            case 4:
                break;
            case 5:
                int i6 = S.f9672h;
                break;
            case 6:
                int i7 = W.f9686c;
                break;
            default:
                int i8 = a0.f9700d;
                break;
        }
        return null;
    }
}
