package tf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f22034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bf.c f22035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.m f22036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bf.g f22037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bf.h f22038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bf.a f22039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vf.s f22040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w0 f22041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k0 f22042i;

    public p(n components, bf.c nameResolver, fe.m containingDeclaration, bf.g typeTable, bf.h versionRequirementTable, bf.a metadataVersion, vf.s sVar, w0 w0Var, List typeParameters) {
        String strC;
        kotlin.jvm.internal.t.f(components, "components");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.t.f(typeTable, "typeTable");
        kotlin.jvm.internal.t.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.t.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.t.f(typeParameters, "typeParameters");
        this.f22034a = components;
        this.f22035b = nameResolver;
        this.f22036c = containingDeclaration;
        this.f22037d = typeTable;
        this.f22038e = versionRequirementTable;
        this.f22039f = metadataVersion;
        this.f22040g = sVar;
        this.f22041h = new w0(this, w0Var, typeParameters, "Deserializer for \"" + containingDeclaration.getName() + '\"', (sVar == null || (strC = sVar.c()) == null) ? "[container not found]" : strC);
        this.f22042i = new k0(this);
    }

    public static /* synthetic */ p b(p pVar, fe.m mVar, List list, bf.c cVar, bf.g gVar, bf.h hVar, bf.a aVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            cVar = pVar.f22035b;
        }
        bf.c cVar2 = cVar;
        if ((i10 & 8) != 0) {
            gVar = pVar.f22037d;
        }
        bf.g gVar2 = gVar;
        if ((i10 & 16) != 0) {
            hVar = pVar.f22038e;
        }
        bf.h hVar2 = hVar;
        if ((i10 & 32) != 0) {
            aVar = pVar.f22039f;
        }
        return pVar.a(mVar, list, cVar2, gVar2, hVar2, aVar);
    }

    public final p a(fe.m descriptor, List typeParameterProtos, bf.c nameResolver, bf.g typeTable, bf.h versionRequirementTable, bf.a metadataVersion) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(typeTable, "typeTable");
        kotlin.jvm.internal.t.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.t.f(metadataVersion, "metadataVersion");
        return new p(this.f22034a, nameResolver, descriptor, typeTable, bf.i.b(metadataVersion) ? versionRequirementTable : this.f22038e, metadataVersion, this.f22040g, this.f22041h, typeParameterProtos);
    }

    public final n c() {
        return this.f22034a;
    }

    public final vf.s d() {
        return this.f22040g;
    }

    public final fe.m e() {
        return this.f22036c;
    }

    public final k0 f() {
        return this.f22042i;
    }

    public final bf.c g() {
        return this.f22035b;
    }

    public final wf.n h() {
        return this.f22034a.u();
    }

    public final w0 i() {
        return this.f22041h;
    }

    public final bf.g j() {
        return this.f22037d;
    }

    public final bf.h k() {
        return this.f22038e;
    }
}
