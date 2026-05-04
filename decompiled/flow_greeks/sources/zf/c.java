package zf;

import dd.r;
import fe.a;
import fe.b;
import fe.b1;
import fe.e0;
import fe.f1;
import fe.g1;
import fe.u;
import fe.z;
import ie.o0;
import ie.s;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.t;
import xf.d2;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends o0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(fe.e containingDeclaration) {
        super(containingDeclaration, null, ge.h.L.b(), ef.f.o(b.f26457c.b()), b.a.DECLARATION, g1.f9483a);
        t.f(containingDeclaration, "containingDeclaration");
        R0(null, null, r.k(), r.k(), r.k(), l.d(k.f26518k, new String[0]), e0.f9463d, fe.t.f9511e);
    }

    @Override // ie.o0, ie.s
    public s L0(fe.m newOwner, z zVar, b.a kind, ef.f fVar, ge.h annotations, g1 source) {
        t.f(newOwner, "newOwner");
        t.f(kind, "kind");
        t.f(annotations, "annotations");
        t.f(source, "source");
        return this;
    }

    @Override // ie.s, fe.z
    public boolean isSuspend() {
        return false;
    }

    @Override // ie.o0, fe.b
    /* JADX INFO: renamed from: k1, reason: merged with bridge method [inline-methods] */
    public f1 L(fe.m newOwner, e0 modality, u visibility, b.a kind, boolean z10) {
        t.f(newOwner, "newOwner");
        t.f(modality, "modality");
        t.f(visibility, "visibility");
        t.f(kind, "kind");
        return this;
    }

    @Override // ie.o0, ie.s, fe.z
    public z.a u() {
        return new a();
    }

    @Override // ie.s, fe.b
    public void w0(Collection overriddenDescriptors) {
        t.f(overriddenDescriptors, "overriddenDescriptors");
    }

    @Override // ie.s, fe.a
    public Object z(a.InterfaceC0175a key) {
        t.f(key, "key");
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements z.a {
        public a() {
        }

        @Override // fe.z.a
        public z.a b(List parameters) {
            t.f(parameters, "parameters");
            return this;
        }

        @Override // fe.z.a
        public z.a d(u visibility) {
            t.f(visibility, "visibility");
            return this;
        }

        @Override // fe.z.a
        public z.a g(r0 type) {
            t.f(type, "type");
            return this;
        }

        @Override // fe.z.a
        public z.a j(ef.f name) {
            t.f(name, "name");
            return this;
        }

        @Override // fe.z.a
        public z.a k(d2 substitution) {
            t.f(substitution, "substitution");
            return this;
        }

        @Override // fe.z.a
        public z.a l(List parameters) {
            t.f(parameters, "parameters");
            return this;
        }

        @Override // fe.z.a
        public z.a m(b.a kind) {
            t.f(kind, "kind");
            return this;
        }

        @Override // fe.z.a
        public z.a n(ge.h additionalAnnotations) {
            t.f(additionalAnnotations, "additionalAnnotations");
            return this;
        }

        @Override // fe.z.a
        public z.a p(fe.m owner) {
            t.f(owner, "owner");
            return this;
        }

        @Override // fe.z.a
        public z.a q(a.InterfaceC0175a userDataKey, Object obj) {
            t.f(userDataKey, "userDataKey");
            return this;
        }

        @Override // fe.z.a
        public z.a s(e0 modality) {
            t.f(modality, "modality");
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public f1 build() {
            return c.this;
        }

        @Override // fe.z.a
        public z.a a() {
            return this;
        }

        @Override // fe.z.a
        public z.a e() {
            return this;
        }

        @Override // fe.z.a
        public z.a h() {
            return this;
        }

        @Override // fe.z.a
        public z.a o() {
            return this;
        }

        @Override // fe.z.a
        public z.a t() {
            return this;
        }

        @Override // fe.z.a
        public z.a c(b1 b1Var) {
            return this;
        }

        @Override // fe.z.a
        public z.a f(b1 b1Var) {
            return this;
        }

        @Override // fe.z.a
        public z.a i(boolean z10) {
            return this;
        }

        @Override // fe.z.a
        public z.a r(fe.b bVar) {
            return this;
        }
    }
}
