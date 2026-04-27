package I4;

import Q4.a;
import V4.j;
import android.content.Context;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Q4.a, R4.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3039f = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f3040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public dev.fluttercommunity.plus.share.a f3041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f3042e;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    @Override // R4.a
    public void onAttachedToActivity(R4.c binding) {
        r.f(binding, "binding");
        dev.fluttercommunity.plus.share.a aVar = this.f3041d;
        d dVar = null;
        if (aVar == null) {
            r.s("manager");
            aVar = null;
        }
        binding.f(aVar);
        d dVar2 = this.f3040c;
        if (dVar2 == null) {
            r.s("share");
        } else {
            dVar = dVar2;
        }
        dVar.o(binding.g());
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b binding) {
        r.f(binding, "binding");
        this.f3042e = new j(binding.b(), "dev.fluttercommunity.plus/share");
        Context contextA = binding.a();
        r.e(contextA, "getApplicationContext(...)");
        this.f3041d = new dev.fluttercommunity.plus.share.a(contextA);
        Context contextA2 = binding.a();
        r.e(contextA2, "getApplicationContext(...)");
        dev.fluttercommunity.plus.share.a aVar = this.f3041d;
        j jVar = null;
        if (aVar == null) {
            r.s("manager");
            aVar = null;
        }
        d dVar = new d(contextA2, null, aVar);
        this.f3040c = dVar;
        dev.fluttercommunity.plus.share.a aVar2 = this.f3041d;
        if (aVar2 == null) {
            r.s("manager");
            aVar2 = null;
        }
        I4.a aVar3 = new I4.a(dVar, aVar2);
        j jVar2 = this.f3042e;
        if (jVar2 == null) {
            r.s("methodChannel");
        } else {
            jVar = jVar2;
        }
        jVar.e(aVar3);
    }

    @Override // R4.a
    public void onDetachedFromActivity() {
        d dVar = this.f3040c;
        if (dVar == null) {
            r.s("share");
            dVar = null;
        }
        dVar.o(null);
    }

    @Override // R4.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b binding) {
        r.f(binding, "binding");
        j jVar = this.f3042e;
        if (jVar == null) {
            r.s("methodChannel");
            jVar = null;
        }
        jVar.e(null);
    }

    @Override // R4.a
    public void onReattachedToActivityForConfigChanges(R4.c binding) {
        r.f(binding, "binding");
        onAttachedToActivity(binding);
    }
}
