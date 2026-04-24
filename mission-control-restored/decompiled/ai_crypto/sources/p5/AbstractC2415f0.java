package p5;

import Q4.a;
import android.content.res.AssetManager;

/* JADX INFO: renamed from: p5.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2415f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f21872a;

    /* JADX INFO: renamed from: p5.f0$a */
    public static class a extends AbstractC2415f0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a.InterfaceC0075a f21873b;

        public a(AssetManager assetManager, a.InterfaceC0075a interfaceC0075a) {
            super(assetManager);
            this.f21873b = interfaceC0075a;
        }

        @Override // p5.AbstractC2415f0
        public String a(String str) {
            return this.f21873b.a(str);
        }
    }

    public AbstractC2415f0(AssetManager assetManager) {
        this.f21872a = assetManager;
    }

    public abstract String a(String str);

    public String[] b(String str) {
        return this.f21872a.list(str);
    }
}
