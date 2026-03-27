package r0;

import H.h;
import H.i;
import android.app.Notification;
import android.media.session.MediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;

/* JADX INFO: renamed from: r0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2669a extends i.j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f22905e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaSessionCompat.Token f22906f;

    @Override // H.i.j
    public void b(h hVar) {
        hVar.a().setStyle(n(new Notification.MediaStyle()));
    }

    @Override // H.i.j
    public RemoteViews i(h hVar) {
        return null;
    }

    @Override // H.i.j
    public RemoteViews j(h hVar) {
        return null;
    }

    public Notification.MediaStyle n(Notification.MediaStyle mediaStyle) {
        int[] iArr = this.f22905e;
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat.Token token = this.f22906f;
        if (token != null) {
            mediaStyle.setMediaSession((MediaSession.Token) token.a());
        }
        return mediaStyle;
    }
}
