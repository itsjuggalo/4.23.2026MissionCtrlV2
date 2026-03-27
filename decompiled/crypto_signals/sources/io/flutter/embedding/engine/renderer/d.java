package io.flutter.embedding.engine.renderer;

import io.flutter.view.o;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f7041b;

    public /* synthetic */ d(o oVar, int i) {
        this.f7040a = i;
        this.f7041b = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7040a) {
            case 0:
                ((FlutterRenderer$ImageReaderSurfaceProducer) this.f7041b).lambda$dequeueImage$0();
                break;
            default:
                ((i) this.f7041b).getClass();
                break;
        }
    }
}
