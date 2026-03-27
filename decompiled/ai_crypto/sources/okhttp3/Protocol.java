package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20597a;

    Protocol(String str) {
        this.f20597a = str;
    }

    public static Protocol a(String str) throws IOException {
        Protocol protocol = HTTP_1_0;
        if (str.equals(protocol.f20597a)) {
            return protocol;
        }
        Protocol protocol2 = HTTP_1_1;
        if (str.equals(protocol2.f20597a)) {
            return protocol2;
        }
        Protocol protocol3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(protocol3.f20597a)) {
            return protocol3;
        }
        Protocol protocol4 = HTTP_2;
        if (str.equals(protocol4.f20597a)) {
            return protocol4;
        }
        Protocol protocol5 = SPDY_3;
        if (str.equals(protocol5.f20597a)) {
            return protocol5;
        }
        Protocol protocol6 = QUIC;
        if (str.equals(protocol6.f20597a)) {
            return protocol6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f20597a;
    }
}
