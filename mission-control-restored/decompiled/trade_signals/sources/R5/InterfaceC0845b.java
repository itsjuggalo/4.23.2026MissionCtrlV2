package R5;

import java.util.Collection;

/* JADX INFO: renamed from: R5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC0845b extends InterfaceC0844a, D {

    /* JADX INFO: renamed from: R5.b$a */
    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean a() {
            return this != FAKE_OVERRIDE;
        }
    }

    InterfaceC0845b P(InterfaceC0856m interfaceC0856m, E e8, AbstractC0863u abstractC0863u, a aVar, boolean z7);

    @Override // R5.InterfaceC0844a, R5.InterfaceC0856m
    InterfaceC0845b a();

    @Override // R5.InterfaceC0844a
    Collection f();

    a i();

    void z0(Collection collection);
}
