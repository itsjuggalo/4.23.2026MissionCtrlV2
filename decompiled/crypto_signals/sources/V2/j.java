package V2;

import android.webkit.JsPromptResult;
import java.util.Objects;
import s4.L;
import s4.S;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements R4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3280c;

    public /* synthetic */ j(int i, Object obj, Object obj2) {
        this.f3278a = i;
        this.f3279b = obj;
        this.f3280c = obj2;
    }

    @Override // R4.l
    public final Object invoke(Object obj) {
        switch (this.f3278a) {
            case 0:
                T.b bVar = (T.b) obj;
                l lVar = (l) this.f3279b;
                lVar.getClass();
                T.e eVar = l.f3285d;
                String str = (String) this.f3280c;
                bVar.e(eVar, str);
                lVar.d(bVar, str);
                return null;
            case 1:
                ((b5.c) this.f3279b).f4894c.removeCallbacks((A.a) this.f3280c);
                return G4.l.f540a;
            case 2:
                ((j5.c) this.f3280c).getClass();
                ((j5.d) this.f3279b).f(null);
                return G4.l.f540a;
            default:
                L l6 = (L) obj;
                S s6 = (S) this.f3279b;
                if (l6.f9653d) {
                    A.f fVar = s6.f9673b.f9720a;
                    Throwable th = l6.f9652c;
                    Objects.requireNonNull(th);
                    fVar.getClass();
                    A.f.f(th);
                    return null;
                }
                String str2 = (String) l6.f9651b;
                JsPromptResult jsPromptResult = (JsPromptResult) this.f3280c;
                if (str2 != null) {
                    jsPromptResult.confirm(str2);
                    return null;
                }
                jsPromptResult.cancel();
                return null;
        }
    }
}
