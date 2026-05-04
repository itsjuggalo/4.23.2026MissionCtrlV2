package f9;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import n9.v;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f9423g = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f9424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputStream f9425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStreamReader f9426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f9427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteBuffer f9428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f9429f;

    public f(g gVar, InputStream inputStream) {
        this.f9424a = gVar;
        this.f9425b = inputStream;
        this.f9426c = new InputStreamReader(inputStream);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
        this.f9428e = byteBufferAllocate;
        byteBufferAllocate.flip();
    }

    public final IllegalArgumentException a(String str) throws IOException {
        b();
        throw new IllegalArgumentException("Invalid bundle: " + str);
    }

    public void b() throws IOException {
        this.f9425b.close();
    }

    public final c c(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("metadata")) {
            e eVarB = this.f9424a.b(jSONObject.getJSONObject("metadata"));
            v.a("BundleElement", "BundleMetadata element loaded", new Object[0]);
            return eVarB;
        }
        if (jSONObject.has("namedQuery")) {
            j jVarQ = this.f9424a.q(jSONObject.getJSONObject("namedQuery"));
            v.a("BundleElement", "Query loaded: " + jVarQ.b(), new Object[0]);
            return jVarQ;
        }
        if (jSONObject.has("documentMetadata")) {
            h hVarC = this.f9424a.c(jSONObject.getJSONObject("documentMetadata"));
            v.a("BundleElement", "Document metadata loaded: " + hVarC.b(), new Object[0]);
            return hVarC;
        }
        if (!jSONObject.has("document")) {
            throw a("Cannot decode unknown Bundle element: " + str);
        }
        b bVarF = this.f9424a.f(jSONObject.getJSONObject("document"));
        v.a("BundleElement", "Document loaded: " + bVarF.b(), new Object[0]);
        return bVarF;
    }

    public e d() {
        e eVar = this.f9427d;
        if (eVar != null) {
            return eVar;
        }
        c cVarK = k();
        if (!(cVarK instanceof e)) {
            throw a("Expected first element in bundle to be a metadata object");
        }
        e eVar2 = (e) cVarK;
        this.f9427d = eVar2;
        this.f9429f = 0L;
        return eVar2;
    }

    public long e() {
        return this.f9429f;
    }

    public c f() {
        d();
        return k();
    }

    public final int g() {
        this.f9428e.mark();
        for (int i10 = 0; i10 < this.f9428e.remaining(); i10++) {
            try {
                if (this.f9428e.get() == 123) {
                    return i10;
                }
            } finally {
                this.f9428e.reset();
            }
        }
        this.f9428e.reset();
        return -1;
    }

    public final boolean h() throws IOException {
        this.f9428e.compact();
        int i10 = this.f9425b.read(this.f9428e.array(), this.f9428e.arrayOffset() + this.f9428e.position(), this.f9428e.remaining());
        boolean z10 = i10 > 0;
        if (z10) {
            ByteBuffer byteBuffer = this.f9428e;
            byteBuffer.position(byteBuffer.position() + i10);
        }
        this.f9428e.flip();
        return z10;
    }

    public final String i(int i10) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (i10 > 0) {
            if (this.f9428e.remaining() == 0 && !h()) {
                throw a("Reached the end of bundle when more data was expected.");
            }
            int iMin = Math.min(i10, this.f9428e.remaining());
            byteArrayOutputStream.write(this.f9428e.array(), this.f9428e.arrayOffset() + this.f9428e.position(), iMin);
            ByteBuffer byteBuffer = this.f9428e;
            byteBuffer.position(byteBuffer.position() + iMin);
            i10 -= iMin;
        }
        return byteArrayOutputStream.toString(f9423g.name());
    }

    public final String j() {
        int iG;
        do {
            iG = g();
            if (iG != -1) {
                break;
            }
        } while (h());
        if (this.f9428e.remaining() == 0) {
            return null;
        }
        if (iG == -1) {
            throw a("Reached the end of bundle when a length string is expected.");
        }
        byte[] bArr = new byte[iG];
        this.f9428e.get(bArr);
        return f9423g.decode(ByteBuffer.wrap(bArr)).toString();
    }

    public final c k() {
        String strJ = j();
        if (strJ == null) {
            return null;
        }
        int i10 = Integer.parseInt(strJ);
        String strI = i(i10);
        this.f9429f += (long) (strJ.getBytes(f9423g).length + i10);
        return c(strI);
    }
}
