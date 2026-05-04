package ea;

import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f8596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MessageType f8597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f8598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f8599d;

    public i(e eVar, MessageType messageType, Map map) {
        this.f8598c = eVar;
        this.f8597b = messageType;
        this.f8599d = map;
    }

    public e a() {
        return this.f8598c;
    }

    public g b() {
        return this.f8596a;
    }

    public MessageType c() {
        return this.f8597b;
    }
}
