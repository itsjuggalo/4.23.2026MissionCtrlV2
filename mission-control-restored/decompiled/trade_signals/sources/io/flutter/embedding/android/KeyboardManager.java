package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.KeyboardChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.InputConnectionAdaptor;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KeyboardManager implements InputConnectionAdaptor.KeyboardDelegate, KeyboardChannel.KeyboardMethodHandler {
    private static final String TAG = "KeyboardManager";
    private final HashSet<KeyEvent> redispatchedEvents = new HashSet<>();
    protected final Responder[] responders;
    private final ViewDelegate viewDelegate;

    public static class CharacterCombiner {
        private int combiningCharacter = 0;

        public Character applyCombiningCharacterToBaseCharacter(int i8) {
            int deadChar;
            char c8 = (char) i8;
            if ((Integer.MIN_VALUE & i8) == 0) {
                int i9 = this.combiningCharacter;
                if (i9 != 0) {
                    int deadChar2 = KeyCharacterMap.getDeadChar(i9, i8);
                    if (deadChar2 > 0) {
                        c8 = (char) deadChar2;
                    }
                    deadChar = 0;
                }
                return Character.valueOf(c8);
            }
            deadChar = i8 & Integer.MAX_VALUE;
            int i10 = this.combiningCharacter;
            if (i10 != 0) {
                deadChar = KeyCharacterMap.getDeadChar(i10, deadChar);
            }
            this.combiningCharacter = deadChar;
            return Character.valueOf(c8);
        }
    }

    public class PerEventCallbackBuilder {
        boolean isEventHandled = false;
        final KeyEvent keyEvent;
        int unrepliedCount;

        public class Callback implements Responder.OnKeyEventHandledCallback {
            boolean isCalled;

            private Callback() {
                this.isCalled = false;
            }

            @Override // io.flutter.embedding.android.KeyboardManager.Responder.OnKeyEventHandledCallback
            public void onKeyEventHandled(boolean z7) {
                if (this.isCalled) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.isCalled = true;
                PerEventCallbackBuilder perEventCallbackBuilder = PerEventCallbackBuilder.this;
                int i8 = perEventCallbackBuilder.unrepliedCount - 1;
                perEventCallbackBuilder.unrepliedCount = i8;
                boolean z8 = z7 | perEventCallbackBuilder.isEventHandled;
                perEventCallbackBuilder.isEventHandled = z8;
                if (i8 != 0 || z8) {
                    return;
                }
                KeyboardManager.this.onUnhandled(perEventCallbackBuilder.keyEvent);
            }
        }

        public PerEventCallbackBuilder(KeyEvent keyEvent) {
            this.unrepliedCount = KeyboardManager.this.responders.length;
            this.keyEvent = keyEvent;
        }

        public Responder.OnKeyEventHandledCallback buildCallback() {
            return new Callback();
        }
    }

    public interface Responder {

        public interface OnKeyEventHandledCallback {
            void onKeyEventHandled(boolean z7);
        }

        void handleEvent(KeyEvent keyEvent, OnKeyEventHandledCallback onKeyEventHandledCallback);
    }

    public interface ViewDelegate {
        BinaryMessenger getBinaryMessenger();

        boolean onTextInputKeyEvent(KeyEvent keyEvent);

        void redispatch(KeyEvent keyEvent);
    }

    public KeyboardManager(ViewDelegate viewDelegate) {
        this.viewDelegate = viewDelegate;
        this.responders = new Responder[]{new KeyEmbedderResponder(viewDelegate.getBinaryMessenger()), new KeyChannelResponder(new KeyEventChannel(viewDelegate.getBinaryMessenger()))};
        new KeyboardChannel(viewDelegate.getBinaryMessenger()).setKeyboardMethodHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUnhandled(KeyEvent keyEvent) {
        ViewDelegate viewDelegate = this.viewDelegate;
        if (viewDelegate == null || viewDelegate.onTextInputKeyEvent(keyEvent)) {
            return;
        }
        this.redispatchedEvents.add(keyEvent);
        this.viewDelegate.redispatch(keyEvent);
        if (this.redispatchedEvents.remove(keyEvent)) {
            Log.w(TAG, "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }

    public void destroy() {
        int size = this.redispatchedEvents.size();
        if (size > 0) {
            Log.w(TAG, "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    @Override // io.flutter.embedding.engine.systemchannels.KeyboardChannel.KeyboardMethodHandler
    public Map<Long, Long> getKeyboardState() {
        return ((KeyEmbedderResponder) this.responders[0]).getPressedState();
    }

    @Override // io.flutter.plugin.editing.InputConnectionAdaptor.KeyboardDelegate
    public boolean handleEvent(KeyEvent keyEvent) {
        if (this.redispatchedEvents.remove(keyEvent)) {
            return false;
        }
        if (this.responders.length <= 0) {
            onUnhandled(keyEvent);
            return true;
        }
        PerEventCallbackBuilder perEventCallbackBuilder = new PerEventCallbackBuilder(keyEvent);
        for (Responder responder : this.responders) {
            responder.handleEvent(keyEvent, perEventCallbackBuilder.buildCallback());
        }
        return true;
    }
}
