package v5;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public enum i {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24922a;

    i(String str) {
        this.f24922a = str;
    }

    public static i a(String str) throws IOException {
        i iVar = HTTP_1_0;
        if (str.equals(iVar.f24922a)) {
            return iVar;
        }
        i iVar2 = HTTP_1_1;
        if (str.equals(iVar2.f24922a)) {
            return iVar2;
        }
        i iVar3 = HTTP_2;
        if (str.equals(iVar3.f24922a)) {
            return iVar3;
        }
        i iVar4 = SPDY_3;
        if (str.equals(iVar4.f24922a)) {
            return iVar4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f24922a;
    }
}
