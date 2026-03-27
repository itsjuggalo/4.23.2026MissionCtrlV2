package D3;

import l2.AbstractC2328l;

/* JADX INFO: loaded from: classes.dex */
public interface r {

    public enum a {
        UNKNOWN_DISMISS_TYPE,
        AUTO,
        CLICK,
        SWIPE
    }

    public enum b {
        UNSPECIFIED_RENDER_ERROR,
        IMAGE_FETCH_ERROR,
        IMAGE_DISPLAY_ERROR,
        IMAGE_UNSUPPORTED_FORMAT
    }

    AbstractC2328l a(b bVar);

    AbstractC2328l b(R3.a aVar);

    AbstractC2328l c(a aVar);

    AbstractC2328l d();
}
