package io.flutter.embedding.engine.plugins;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface PluginRegistry {
    void add(FlutterPlugin flutterPlugin);

    void add(Set<FlutterPlugin> set);

    FlutterPlugin get(Class<? extends FlutterPlugin> cls);

    boolean has(Class<? extends FlutterPlugin> cls);

    void remove(Class<? extends FlutterPlugin> cls);

    void remove(Set<Class<? extends FlutterPlugin>> set);

    void removeAll();
}
