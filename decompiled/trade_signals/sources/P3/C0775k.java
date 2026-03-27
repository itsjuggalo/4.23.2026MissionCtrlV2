package P3;

import N3.V0;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: renamed from: P3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0775k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnalyticsConnector f6412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A3.d f6413b;

    public C0775k(S3.a aVar, A3.d dVar) {
        this.f6412a = new V0(aVar);
        this.f6413b = dVar;
    }

    public AnalyticsConnector a() {
        return this.f6412a;
    }

    public A3.d b() {
        return this.f6413b;
    }
}
