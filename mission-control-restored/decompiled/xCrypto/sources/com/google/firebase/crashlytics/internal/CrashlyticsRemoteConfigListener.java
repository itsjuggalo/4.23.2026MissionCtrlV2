package com.google.firebase.crashlytics.internal;

import X2.AbstractC0770q;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CrashlyticsRemoteConfigListener implements RolloutsStateSubscriber {
    private final UserMetadata userMetadata;

    public CrashlyticsRemoteConfigListener(UserMetadata userMetadata) {
        r.f(userMetadata, "userMetadata");
        this.userMetadata = userMetadata;
    }

    @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber
    public void onRolloutsStateChanged(RolloutsState rolloutsState) {
        r.f(rolloutsState, "rolloutsState");
        UserMetadata userMetadata = this.userMetadata;
        Set<RolloutAssignment> rolloutAssignments = rolloutsState.getRolloutAssignments();
        r.e(rolloutAssignments, "rolloutsState.rolloutAssignments");
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(rolloutAssignments, 10));
        for (RolloutAssignment rolloutAssignment : rolloutAssignments) {
            arrayList.add(com.google.firebase.crashlytics.internal.metadata.RolloutAssignment.create(rolloutAssignment.getRolloutId(), rolloutAssignment.getParameterKey(), rolloutAssignment.getParameterValue(), rolloutAssignment.getVariantId(), rolloutAssignment.getTemplateVersion()));
        }
        userMetadata.updateRolloutsState(arrayList);
        Logger.getLogger().d("Updated Crashlytics Rollout State");
    }
}
