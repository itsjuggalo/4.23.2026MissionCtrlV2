package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface n1 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements n1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25026a = new a();

        @Override // xf.n1
        public void a(ge.c annotation) {
            kotlin.jvm.internal.t.f(annotation, "annotation");
        }

        @Override // xf.n1
        public void b(f2 substitutor, r0 unsubstitutedArgument, r0 argument, fe.l1 typeParameter) {
            kotlin.jvm.internal.t.f(substitutor, "substitutor");
            kotlin.jvm.internal.t.f(unsubstitutedArgument, "unsubstitutedArgument");
            kotlin.jvm.internal.t.f(argument, "argument");
            kotlin.jvm.internal.t.f(typeParameter, "typeParameter");
        }

        @Override // xf.n1
        public void c(fe.k1 typeAlias, fe.l1 l1Var, r0 substitutedArgument) {
            kotlin.jvm.internal.t.f(typeAlias, "typeAlias");
            kotlin.jvm.internal.t.f(substitutedArgument, "substitutedArgument");
        }

        @Override // xf.n1
        public void d(fe.k1 typeAlias) {
            kotlin.jvm.internal.t.f(typeAlias, "typeAlias");
        }
    }

    void a(ge.c cVar);

    void b(f2 f2Var, r0 r0Var, r0 r0Var2, fe.l1 l1Var);

    void c(fe.k1 k1Var, fe.l1 l1Var, r0 r0Var);

    void d(fe.k1 k1Var);
}
