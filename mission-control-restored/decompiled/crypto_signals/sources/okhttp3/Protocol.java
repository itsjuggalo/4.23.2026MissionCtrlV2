package okhttp3;

/* JADX INFO: loaded from: classes.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    /* JADX INFO: Fake field, exist only in values array */
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    /* JADX INFO: Fake field, exist only in values array */
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    /* JADX INFO: Fake field, exist only in values array */
    QUIC("quic");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8817a;

    Protocol(String str) {
        this.f8817a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f8817a;
    }
}
