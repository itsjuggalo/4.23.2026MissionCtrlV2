package R3;

import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f7163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MessageType f7164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f7165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f7166d;

    public i(e eVar, MessageType messageType, Map map) {
        this.f7165c = eVar;
        this.f7164b = messageType;
        this.f7166d = map;
    }

    public e a() {
        return this.f7165c;
    }

    public g b() {
        return this.f7163a;
    }

    public MessageType c() {
        return this.f7164b;
    }
}
