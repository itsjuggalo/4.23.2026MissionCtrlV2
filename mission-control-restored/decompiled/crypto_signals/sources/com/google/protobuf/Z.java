package com.google.protobuf;

import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class Z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final B f5701b = new B(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5702a;

    public Z(AbstractC0485s abstractC0485s) {
        M.a(abstractC0485s, "output");
        this.f5702a = abstractC0485s;
        abstractC0485s.f5795c = this;
    }

    public void a(AbstractC0472l abstractC0472l) {
        if (!abstractC0472l.o()) {
            if (!(abstractC0472l instanceof C0486s0)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + abstractC0472l.getClass());
            }
            C0486s0 c0486s0 = (C0486s0) abstractC0472l;
            a(c0486s0.e);
            a(c0486s0.f5798f);
            return;
        }
        int iBinarySearch = Arrays.binarySearch(C0486s0.f5796m, abstractC0472l.size());
        if (iBinarySearch < 0) {
            iBinarySearch = (-(iBinarySearch + 1)) - 1;
        }
        int iX = C0486s0.x(iBinarySearch + 1);
        ArrayDeque arrayDeque = (ArrayDeque) this.f5702a;
        if (arrayDeque.isEmpty() || ((AbstractC0472l) arrayDeque.peek()).size() >= iX) {
            arrayDeque.push(abstractC0472l);
            return;
        }
        int iX2 = C0486s0.x(iBinarySearch);
        AbstractC0472l c0486s02 = (AbstractC0472l) arrayDeque.pop();
        while (!arrayDeque.isEmpty() && ((AbstractC0472l) arrayDeque.peek()).size() < iX2) {
            c0486s02 = new C0486s0((AbstractC0472l) arrayDeque.pop(), c0486s02);
        }
        C0486s0 c0486s03 = new C0486s0(c0486s02, abstractC0472l);
        while (!arrayDeque.isEmpty()) {
            int iBinarySearch2 = Arrays.binarySearch(C0486s0.f5796m, c0486s03.f5797d);
            if (iBinarySearch2 < 0) {
                iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
            }
            if (((AbstractC0472l) arrayDeque.peek()).size() >= C0486s0.x(iBinarySearch2 + 1)) {
                break;
            } else {
                c0486s03 = new C0486s0((AbstractC0472l) arrayDeque.pop(), c0486s03);
            }
        }
        arrayDeque.push(c0486s03);
    }

    public void b(int i, Object obj, InterfaceC0488t0 interfaceC0488t0) {
        AbstractC0485s abstractC0485s = (AbstractC0485s) this.f5702a;
        abstractC0485s.V(i, 3);
        interfaceC0488t0.f((AbstractC0450a) obj, abstractC0485s.f5795c);
        abstractC0485s.V(i, 4);
    }

    public Z(int i) {
        InterfaceC0461f0 interfaceC0461f0;
        switch (i) {
            case 2:
                this.f5702a = new ArrayDeque();
                break;
            default:
                try {
                    interfaceC0461f0 = (InterfaceC0461f0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                } catch (Exception unused) {
                    interfaceC0461f0 = f5701b;
                }
                InterfaceC0461f0[] interfaceC0461f0Arr = {B.f5633b, interfaceC0461f0};
                Y y = new Y();
                y.f5700a = interfaceC0461f0Arr;
                Charset charset = M.f5651a;
                this.f5702a = y;
                break;
        }
    }
}
