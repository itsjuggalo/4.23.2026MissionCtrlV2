package b3;

import com.google.firebase.components.ComponentRegistrar;
import java.util.List;

/* JADX INFO: renamed from: b3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0992i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC0992i f8538a = new InterfaceC0992i() { // from class: b3.h
        @Override // b3.InterfaceC0992i
        public final List a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar.getComponents();
        }
    };

    List a(ComponentRegistrar componentRegistrar);
}
