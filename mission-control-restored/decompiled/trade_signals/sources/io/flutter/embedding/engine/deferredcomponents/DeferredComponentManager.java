package io.flutter.embedding.engine.deferredcomponents;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;

/* JADX INFO: loaded from: classes.dex */
public interface DeferredComponentManager {
    void destroy();

    String getDeferredComponentInstallState(int i8, String str);

    void installDeferredComponent(int i8, String str);

    void loadAssets(int i8, String str);

    void loadDartLibrary(int i8, String str);

    void setDeferredComponentChannel(DeferredComponentChannel deferredComponentChannel);

    void setJNI(FlutterJNI flutterJNI);

    boolean uninstallDeferredComponent(int i8, String str);
}
