package p7;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lp7/z;", "Lp7/E;", "<init>", "()V", "Lk7/b;", "serializer", "()Lk7/b;", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", FirebaseAnalytics.Param.CONTENT, "", "d", "()Z", "isString", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0})
public final class z extends E {
    public static final z INSTANCE = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final String content = "null";

    public z() {
        super(null);
    }

    @Override // p7.E
    public String a() {
        return content;
    }

    @Override // p7.E
    public boolean d() {
        return false;
    }

    public final k7.b serializer() {
        return A.f22424a;
    }
}
