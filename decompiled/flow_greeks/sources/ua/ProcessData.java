package ua;

import dh.e0;
import dh.e1;
import dh.j1;
import dh.s1;
import dh.w1;
import kotlin.Metadata;

/* JADX INFO: renamed from: ua.v, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0081\b\u0018\u0000  2\u00020\u0001:\u0002\u001c\u001eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\u000bJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010\u0015¨\u0006!"}, d2 = {"Lua/v;", "", "", "pid", "", "uuid", "<init>", "(ILjava/lang/String;)V", "seen0", "Ldh/s1;", "serializationConstructorMarker", "(IILjava/lang/String;Ldh/s1;)V", "self", "Lch/d;", "output", "Lbh/e;", "serialDesc", "Lcd/h0;", "c", "(Lua/v;Lch/d;Lbh/e;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Ljava/lang/String;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ProcessData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int pid;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String uuid;

    /* JADX INFO: renamed from: ua.v$a */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a implements dh.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22715a;
        private static final bh.e descriptor;

        static {
            a aVar = new a();
            f22715a = aVar;
            j1 j1Var = new j1("com.google.firebase.sessions.ProcessData", aVar, 2);
            j1Var.g("pid", false);
            j1Var.g("uuid", false);
            descriptor = j1Var;
        }

        @Override // zg.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ProcessData deserialize(ch.e decoder) {
            int iC;
            String strS;
            int i10;
            kotlin.jvm.internal.t.f(decoder, "decoder");
            bh.e eVar = descriptor;
            ch.c cVarB = decoder.b(eVar);
            s1 s1Var = null;
            if (cVarB.z()) {
                iC = cVarB.C(eVar, 0);
                strS = cVarB.s(eVar, 1);
                i10 = 3;
            } else {
                boolean z10 = true;
                iC = 0;
                int i11 = 0;
                String strS2 = null;
                while (z10) {
                    int iW = cVarB.w(eVar);
                    if (iW == -1) {
                        z10 = false;
                    } else if (iW == 0) {
                        iC = cVarB.C(eVar, 0);
                        i11 |= 1;
                    } else {
                        if (iW != 1) {
                            throw new zg.m(iW);
                        }
                        strS2 = cVarB.s(eVar, 1);
                        i11 |= 2;
                    }
                }
                strS = strS2;
                i10 = i11;
            }
            cVarB.c(eVar);
            return new ProcessData(i10, iC, strS, s1Var);
        }

        @Override // zg.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(ch.f encoder, ProcessData value) {
            kotlin.jvm.internal.t.f(encoder, "encoder");
            kotlin.jvm.internal.t.f(value, "value");
            bh.e eVar = descriptor;
            ch.d dVarB = encoder.b(eVar);
            ProcessData.c(value, dVarB, eVar);
            dVarB.c(eVar);
        }

        @Override // dh.e0
        public final zg.b[] childSerializers() {
            return new zg.b[]{dh.j0.f8162a, w1.f8244a};
        }

        @Override // zg.b, zg.k, zg.a
        public final bh.e getDescriptor() {
            return descriptor;
        }

        @Override // dh.e0
        public zg.b[] typeParametersSerializers() {
            return e0.a.a(this);
        }
    }

    /* JADX INFO: renamed from: ua.v$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class Companion {
        public Companion() {
        }

        public final zg.b serializer() {
            return a.f22715a;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public /* synthetic */ ProcessData(int i10, int i11, String str, s1 s1Var) {
        if (3 != (i10 & 3)) {
            e1.a(i10, 3, a.f22715a.getDescriptor());
        }
        this.pid = i11;
        this.uuid = str;
    }

    public static final /* synthetic */ void c(ProcessData self, ch.d output, bh.e serialDesc) {
        output.x(serialDesc, 0, self.pid);
        output.w(serialDesc, 1, self.uuid);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getPid() {
        return this.pid;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessData)) {
            return false;
        }
        ProcessData processData = (ProcessData) other;
        return this.pid == processData.pid && kotlin.jvm.internal.t.b(this.uuid, processData.uuid);
    }

    public int hashCode() {
        return (Integer.hashCode(this.pid) * 31) + this.uuid.hashCode();
    }

    public String toString() {
        return "ProcessData(pid=" + this.pid + ", uuid=" + this.uuid + ')';
    }

    public ProcessData(int i10, String uuid) {
        kotlin.jvm.internal.t.f(uuid, "uuid");
        this.pid = i10;
        this.uuid = uuid;
    }
}
