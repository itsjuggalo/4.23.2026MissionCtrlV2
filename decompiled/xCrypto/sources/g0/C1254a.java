package g0;

import android.app.Notification;
import android.media.session.MediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import w.j;
import w.k;

/* JADX INFO: renamed from: g0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1254a extends k.j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f11896e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaSessionCompat.Token f11897f;

    @Override // w.k.j
    public void b(j jVar) {
        jVar.a().setStyle(n(new Notification.MediaStyle()));
    }

    @Override // w.k.j
    public RemoteViews i(j jVar) {
        return null;
    }

    @Override // w.k.j
    public RemoteViews j(j jVar) {
        return null;
    }

    public Notification.MediaStyle n(Notification.MediaStyle mediaStyle) {
        int[] iArr = this.f11896e;
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat.Token token = this.f11897f;
        if (token != null) {
            mediaStyle.setMediaSession((MediaSession.Token) token.a());
        }
        return mediaStyle;
    }
}
