package p7;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \r2\u00020\u0001:\u0001\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lp7/E;", "Lp7/i;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "d", "()Z", "isString", "a", FirebaseAnalytics.Param.CONTENT, "Companion", "Lp7/v;", "Lp7/z;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0})
public abstract class E extends i {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: p7.E$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final k7.b serializer() {
            return F.f22432a;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public E() {
        super(null);
    }

    public abstract String a();

    public abstract boolean d();

    public String toString() {
        return a();
    }

    public /* synthetic */ E(AbstractC2296k abstractC2296k) {
        this();
    }
}
