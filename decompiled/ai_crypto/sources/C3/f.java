package C3;

import K3.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f1045g = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputStream f1047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStreamReader f1048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f1049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteBuffer f1050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1051f;

    public f(g gVar, InputStream inputStream) {
        this.f1046a = gVar;
        this.f1047b = inputStream;
        this.f1048c = new InputStreamReader(inputStream);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
        this.f1050e = byteBufferAllocate;
        byteBufferAllocate.flip();
    }

    public final IllegalArgumentException a(String str) throws IOException {
        b();
        throw new IllegalArgumentException("Invalid bundle: " + str);
    }

    public void b() throws IOException {
        this.f1047b.close();
    }

    public final c c(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("metadata")) {
            e eVarB = this.f1046a.b(jSONObject.getJSONObject("metadata"));
            x.a("BundleElement", "BundleMetadata element loaded", new Object[0]);
            return eVarB;
        }
        if (jSONObject.has("namedQuery")) {
            j jVarQ = this.f1046a.q(jSONObject.getJSONObject("namedQuery"));
            x.a("BundleElement", "Query loaded: " + jVarQ.b(), new Object[0]);
            return jVarQ;
        }
        if (jSONObject.has("documentMetadata")) {
            h hVarC = this.f1046a.c(jSONObject.getJSONObject("documentMetadata"));
            x.a("BundleElement", "Document metadata loaded: " + hVarC.b(), new Object[0]);
            return hVarC;
        }
        if (!jSONObject.has("document")) {
            throw a("Cannot decode unknown Bundle element: " + str);
        }
        b bVarF = this.f1046a.f(jSONObject.getJSONObject("document"));
        x.a("BundleElement", "Document loaded: " + bVarF.b(), new Object[0]);
        return bVarF;
    }

    public e d() {
        e eVar = this.f1049d;
        if (eVar != null) {
            return eVar;
        }
        c cVarK = k();
        if (!(cVarK instanceof e)) {
            throw a("Expected first element in bundle to be a metadata object");
        }
        e eVar2 = (e) cVarK;
        this.f1049d = eVar2;
        this.f1051f = 0L;
        return eVar2;
    }

    public long e() {
        return this.f1051f;
    }

    public c f() {
        d();
        return k();
    }

    public final int g() {
        this.f1050e.mark();
        for (int i7 = 0; i7 < this.f1050e.remaining(); i7++) {
            try {
                if (this.f1050e.get() == 123) {
                    return i7;
                }
            } finally {
                this.f1050e.reset();
            }
        }
        this.f1050e.reset();
        return -1;
    }

    public final boolean h() throws IOException {
        this.f1050e.compact();
        int i7 = this.f1047b.read(this.f1050e.array(), this.f1050e.arrayOffset() + this.f1050e.position(), this.f1050e.remaining());
        boolean z7 = i7 > 0;
        if (z7) {
            ByteBuffer byteBuffer = this.f1050e;
            byteBuffer.position(byteBuffer.position() + i7);
        }
        this.f1050e.flip();
        return z7;
    }

    public final String i(int i7) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (i7 > 0) {
            if (this.f1050e.remaining() == 0 && !h()) {
                throw a("Reached the end of bundle when more data was expected.");
            }
            int iMin = Math.min(i7, this.f1050e.remaining());
            byteArrayOutputStream.write(this.f1050e.array(), this.f1050e.arrayOffset() + this.f1050e.position(), iMin);
            ByteBuffer byteBuffer = this.f1050e;
            byteBuffer.position(byteBuffer.position() + iMin);
            i7 -= iMin;
        }
        return byteArrayOutputStream.toString(f1045g.name());
    }

    public final String j() {
        int iG;
        do {
            iG = g();
            if (iG != -1) {
                break;
            }
        } while (h());
        if (this.f1050e.remaining() == 0) {
            return null;
        }
        if (iG == -1) {
            throw a("Reached the end of bundle when a length string is expected.");
        }
        byte[] bArr = new byte[iG];
        this.f1050e.get(bArr);
        return f1045g.decode(ByteBuffer.wrap(bArr)).toString();
    }

    public final c k() {
        String strJ = j();
        if (strJ == null) {
            return null;
        }
        int i7 = Integer.parseInt(strJ);
        String strI = i(i7);
        this.f1051f += (long) (strJ.getBytes(f1045g).length + i7);
        return c(strI);
    }
}
