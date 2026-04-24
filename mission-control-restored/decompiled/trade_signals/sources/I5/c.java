package I5;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends b {
    Object call(Object... objArr);

    Object callBy(Map map);

    String getName();

    List getParameters();

    q getReturnType();

    List getTypeParameters();

    u getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
