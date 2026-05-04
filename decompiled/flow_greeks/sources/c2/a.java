package c2;

import android.app.Notification;
import android.media.session.MediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import h0.h;
import h0.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends i.j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f3560e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaSessionCompat.Token f3561f;

    @Override // h0.i.j
    public void b(h hVar) {
        hVar.a().setStyle(n(new Notification.MediaStyle()));
    }

    @Override // h0.i.j
    public RemoteViews i(h hVar) {
        return null;
    }

    @Override // h0.i.j
    public RemoteViews j(h hVar) {
        return null;
    }

    public Notification.MediaStyle n(Notification.MediaStyle mediaStyle) {
        int[] iArr = this.f3560e;
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat.Token token = this.f3561f;
        if (token != null) {
            mediaStyle.setMediaSession((MediaSession.Token) token.a());
        }
        return mediaStyle;
    }
}
