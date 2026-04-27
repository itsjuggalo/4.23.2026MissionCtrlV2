package w0;

import v0.AbstractC1254a;

/* JADX INFO: loaded from: classes.dex */
public final class j extends C1273b {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(String str, int i, String str2) {
        super(str, 2, str2);
        this.e = i;
    }

    @Override // w0.AbstractC1274c
    public final boolean b() {
        switch (this.e) {
            case 0:
                if (!super.b() || !android.support.v4.media.session.a.r("MULTI_PROCESS")) {
                    return false;
                }
                int i = AbstractC1254a.f10601a;
                if (k.f10709c.b()) {
                    return m.f10712a.getStatics().isMultiProcessEnabled();
                }
                throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
            default:
                if (android.support.v4.media.session.a.r("MULTI_PROFILE")) {
                    return super.b();
                }
                return false;
        }
    }
}
