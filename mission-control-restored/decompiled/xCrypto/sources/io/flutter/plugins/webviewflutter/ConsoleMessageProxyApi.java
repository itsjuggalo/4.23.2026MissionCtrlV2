package io.flutter.plugins.webviewflutter;

import android.webkit.ConsoleMessage;

/* JADX INFO: loaded from: classes3.dex */
public class ConsoleMessageProxyApi extends PigeonApiConsoleMessage {

    /* JADX INFO: renamed from: io.flutter.plugins.webviewflutter.ConsoleMessageProxyApi$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$webkit$ConsoleMessage$MessageLevel;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ConsoleMessageProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiConsoleMessage
    public ConsoleMessageLevel level(ConsoleMessage consoleMessage) {
        int i4 = AnonymousClass1.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[consoleMessage.messageLevel().ordinal()];
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? ConsoleMessageLevel.UNKNOWN : ConsoleMessageLevel.DEBUG : ConsoleMessageLevel.ERROR : ConsoleMessageLevel.WARNING : ConsoleMessageLevel.LOG : ConsoleMessageLevel.TIP;
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiConsoleMessage
    public long lineNumber(ConsoleMessage consoleMessage) {
        return consoleMessage.lineNumber();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiConsoleMessage
    public String message(ConsoleMessage consoleMessage) {
        return consoleMessage.message();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiConsoleMessage
    public String sourceId(ConsoleMessage consoleMessage) {
        return consoleMessage.sourceId();
    }
}
