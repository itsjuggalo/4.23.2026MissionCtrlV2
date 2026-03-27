package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.Log;
import io.flutter.embedding.android.KeyData;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.android.KeyboardMap;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class KeyEmbedderResponder implements KeyboardManager.Responder {
    private static final String TAG = "KeyEmbedderResponder";
    private final BinaryMessenger messenger;
    private final HashMap<Long, Long> pressingRecords = new HashMap<>();
    private final HashMap<Long, KeyboardMap.TogglingGoal> togglingGoals = new HashMap<>();
    private final KeyboardManager.CharacterCombiner characterCombiner = new KeyboardManager.CharacterCombiner();

    /* JADX INFO: renamed from: io.flutter.embedding.android.KeyEmbedderResponder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$KeyData$Type;

        static {
            int[] iArr = new int[KeyData.Type.values().length];
            $SwitchMap$io$flutter$embedding$android$KeyData$Type = iArr;
            try {
                iArr[KeyData.Type.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$KeyData$Type[KeyData.Type.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$KeyData$Type[KeyData.Type.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public KeyEmbedderResponder(BinaryMessenger binaryMessenger) {
        this.messenger = binaryMessenger;
        for (KeyboardMap.TogglingGoal togglingGoal : KeyboardMap.getTogglingGoals()) {
            this.togglingGoals.put(Long.valueOf(togglingGoal.logicalKey), togglingGoal);
        }
    }

    public static /* synthetic */ void a(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, long j4, KeyEvent keyEvent) {
        keyEmbedderResponder.getClass();
        keyEmbedderResponder.synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(j4), keyEvent.getEventTime());
    }

    public static /* synthetic */ void b(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, long j4, KeyEvent keyEvent) {
        keyEmbedderResponder.getClass();
        keyEmbedderResponder.synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(j4), keyEvent.getEventTime());
    }

    public static /* synthetic */ void c(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback, ByteBuffer byteBuffer) {
        Boolean boolValueOf = Boolean.FALSE;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            if (byteBuffer.capacity() != 0) {
                boolValueOf = Boolean.valueOf(byteBuffer.get() != 0);
            }
        } else {
            Log.w(TAG, "A null reply was received when sending a key event to the framework.");
        }
        onKeyEventHandledCallback.onKeyEventHandled(boolValueOf.booleanValue());
    }

    private static KeyData.Type getEventType(KeyEvent keyEvent) {
        boolean z4 = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z4 ? KeyData.Type.kRepeat : KeyData.Type.kDown;
        }
        if (action == 1) {
            return KeyData.Type.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    private Long getLogicalKey(KeyEvent keyEvent) {
        Long l4 = KeyboardMap.keyCodeToLogical.get(Long.valueOf(keyEvent.getKeyCode()));
        return l4 != null ? l4 : Long.valueOf(keyOfPlane(keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
    }

    private Long getPhysicalKey(KeyEvent keyEvent) {
        long scanCode = keyEvent.getScanCode();
        if (scanCode == 0) {
            return Long.valueOf(keyOfPlane(keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
        }
        Long l4 = KeyboardMap.scanCodeToPhysical.get(Long.valueOf(scanCode));
        return l4 != null ? l4 : Long.valueOf(keyOfPlane(keyEvent.getScanCode(), KeyboardMap.kAndroidPlane));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0141 A[LOOP:2: B:70:0x013b->B:72:0x0141, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean handleEventImpl(android.view.KeyEvent r16, io.flutter.embedding.android.KeyboardManager.Responder.OnKeyEventHandledCallback r17) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.KeyEmbedderResponder.handleEventImpl(android.view.KeyEvent, io.flutter.embedding.android.KeyboardManager$Responder$OnKeyEventHandledCallback):boolean");
    }

    private static long keyOfPlane(long j4, long j5) {
        return (j4 & KeyboardMap.kValueMask) | j5;
    }

    private void sendKeyEvent(KeyData keyData, final KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.messenger.send(KeyData.CHANNEL, keyData.toBytes(), onKeyEventHandledCallback == null ? null : new BinaryMessenger.BinaryReply() { // from class: io.flutter.embedding.android.v
            @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
            public final void reply(ByteBuffer byteBuffer) {
                KeyEmbedderResponder.c(onKeyEventHandledCallback, byteBuffer);
            }
        });
    }

    private void synthesizeEvent(boolean z4, Long l4, Long l5, long j4) {
        KeyData keyData = new KeyData();
        keyData.timestamp = j4;
        keyData.type = z4 ? KeyData.Type.kDown : KeyData.Type.kUp;
        keyData.logicalKey = l4.longValue();
        keyData.physicalKey = l5.longValue();
        keyData.character = null;
        keyData.synthesized = true;
        keyData.deviceType = KeyData.DeviceType.kKeyboard;
        if (l5.longValue() != 0 && l4.longValue() != 0) {
            if (!z4) {
                l4 = null;
            }
            updatePressingState(l5, l4);
        }
        sendKeyEvent(keyData, null);
    }

    public Map<Long, Long> getPressedState() {
        return Collections.unmodifiableMap(this.pressingRecords);
    }

    @Override // io.flutter.embedding.android.KeyboardManager.Responder
    public void handleEvent(KeyEvent keyEvent, KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        if (handleEventImpl(keyEvent, onKeyEventHandledCallback)) {
            return;
        }
        synthesizeEvent(true, 0L, 0L, 0L);
        onKeyEventHandledCallback.onKeyEventHandled(true);
    }

    public void synchronizePressingKey(KeyboardMap.PressingGoal pressingGoal, boolean z4, long j4, final long j5, final KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        KeyboardMap.KeyPair[] keyPairArr = pressingGoal.keys;
        boolean[] zArr = new boolean[keyPairArr.length];
        Boolean[] boolArr = new Boolean[keyPairArr.length];
        int i4 = 0;
        boolean z5 = false;
        while (true) {
            KeyboardMap.KeyPair[] keyPairArr2 = pressingGoal.keys;
            boolean z6 = true;
            if (i4 >= keyPairArr2.length) {
                break;
            }
            final KeyboardMap.KeyPair keyPair = keyPairArr2[i4];
            boolean zContainsKey = this.pressingRecords.containsKey(Long.valueOf(keyPair.physicalKey));
            zArr[i4] = zContainsKey;
            if (keyPair.logicalKey == j4) {
                int i5 = AnonymousClass1.$SwitchMap$io$flutter$embedding$android$KeyData$Type[getEventType(keyEvent).ordinal()];
                if (i5 != 1) {
                    if (i5 == 2) {
                        boolArr[i4] = Boolean.valueOf(zArr[i4]);
                    } else if (i5 == 3) {
                        if (!z4) {
                            arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.x
                                @Override // java.lang.Runnable
                                public final void run() {
                                    KeyEmbedderResponder.a(this.f12266a, keyPair, j5, keyEvent);
                                }
                            });
                        }
                        boolArr[i4] = Boolean.valueOf(zArr[i4]);
                    }
                    i4++;
                } else {
                    boolArr[i4] = Boolean.FALSE;
                    if (!z4) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                KeyEmbedderResponder.b(this.f12262a, keyPair, j5, keyEvent);
                            }
                        });
                    }
                }
            } else if (!z5 && !zContainsKey) {
                z6 = false;
            }
            z5 = z6;
            i4++;
        }
        if (z4) {
            for (int i6 = 0; i6 < pressingGoal.keys.length; i6++) {
                if (boolArr[i6] == null) {
                    if (z5) {
                        boolArr[i6] = Boolean.valueOf(zArr[i6]);
                    } else {
                        boolArr[i6] = Boolean.TRUE;
                        z5 = true;
                    }
                }
            }
            if (!z5) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i7 = 0; i7 < pressingGoal.keys.length; i7++) {
                if (boolArr[i7] == null) {
                    boolArr[i7] = Boolean.FALSE;
                }
            }
        }
        for (int i8 = 0; i8 < pressingGoal.keys.length; i8++) {
            if (zArr[i8] != boolArr[i8].booleanValue()) {
                KeyboardMap.KeyPair keyPair2 = pressingGoal.keys[i8];
                synthesizeEvent(boolArr[i8].booleanValue(), Long.valueOf(keyPair2.logicalKey), Long.valueOf(keyPair2.physicalKey), keyEvent.getEventTime());
            }
        }
    }

    public void synchronizeTogglingKey(KeyboardMap.TogglingGoal togglingGoal, boolean z4, long j4, KeyEvent keyEvent) {
        if (togglingGoal.logicalKey == j4 || togglingGoal.enabled == z4) {
            return;
        }
        boolean zContainsKey = this.pressingRecords.containsKey(Long.valueOf(togglingGoal.physicalKey));
        boolean z5 = !zContainsKey;
        if (!zContainsKey) {
            togglingGoal.enabled = !togglingGoal.enabled;
        }
        synthesizeEvent(z5, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
        if (zContainsKey) {
            togglingGoal.enabled = !togglingGoal.enabled;
        }
        synthesizeEvent(zContainsKey, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
    }

    public void updatePressingState(Long l4, Long l5) {
        if (l5 != null) {
            if (this.pressingRecords.put(l4, l5) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.pressingRecords.remove(l4) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
