package ie;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f12299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f12300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f12301d;

    public c0(List allDependencies, Set modulesWhoseInternalsAreVisible, List directExpectedByDependencies, Set allExpectedByDependencies) {
        kotlin.jvm.internal.t.f(allDependencies, "allDependencies");
        kotlin.jvm.internal.t.f(modulesWhoseInternalsAreVisible, "modulesWhoseInternalsAreVisible");
        kotlin.jvm.internal.t.f(directExpectedByDependencies, "directExpectedByDependencies");
        kotlin.jvm.internal.t.f(allExpectedByDependencies, "allExpectedByDependencies");
        this.f12298a = allDependencies;
        this.f12299b = modulesWhoseInternalsAreVisible;
        this.f12300c = directExpectedByDependencies;
        this.f12301d = allExpectedByDependencies;
    }

    @Override // ie.b0
    public List a() {
        return this.f12298a;
    }

    @Override // ie.b0
    public Set b() {
        return this.f12299b;
    }

    @Override // ie.b0
    public List c() {
        return this.f12300c;
    }
}
