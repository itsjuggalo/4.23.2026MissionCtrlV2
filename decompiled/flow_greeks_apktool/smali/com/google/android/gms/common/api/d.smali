.class public abstract Lcom/google/android/gms/common/api/d;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# direct methods
.method public static a(I)Ljava/lang/String;
    .locals 2

    .line 1
    packed-switch p0, :pswitch_data_0

    .line 2
    .line 3
    .line 4
    :pswitch_0
    invoke-static {p0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    .line 5
    .line 6
    .line 7
    move-result-object v0

    .line 8
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    .line 9
    .line 10
    .line 11
    move-result v0

    .line 12
    new-instance v1, Ljava/lang/StringBuilder;

    .line 13
    .line 14
    add-int/lit8 v0, v0, 0x15

    .line 15
    .line 16
    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 17
    .line 18
    .line 19
    const-string v0, "unknown status code: "

    .line 20
    .line 21
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 22
    .line 23
    .line 24
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 25
    .line 26
    .line 27
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object p0

    .line 31
    return-object p0

    .line 32
    :pswitch_1
    const-string p0, "RECONNECTION_TIMED_OUT"

    .line 33
    .line 34
    return-object p0

    .line 35
    :pswitch_2
    const-string p0, "RECONNECTION_TIMED_OUT_DURING_UPDATE"

    .line 36
    .line 37
    return-object p0

    .line 38
    :pswitch_3
    const-string p0, "CONNECTION_SUSPENDED_DURING_CALL"

    .line 39
    .line 40
    return-object p0

    .line 41
    :pswitch_4
    const-string p0, "REMOTE_EXCEPTION"

    .line 42
    .line 43
    return-object p0

    .line 44
    :pswitch_5
    const-string p0, "DEAD_CLIENT"

    .line 45
    .line 46
    return-object p0

    .line 47
    :pswitch_6
    const-string p0, "API_NOT_CONNECTED"

    .line 48
    .line 49
    return-object p0

    .line 50
    :pswitch_7
    const-string p0, "CANCELED"

    .line 51
    .line 52
    return-object p0

    .line 53
    :pswitch_8
    const-string p0, "TIMEOUT"

    .line 54
    .line 55
    return-object p0

    .line 56
    :pswitch_9
    const-string p0, "INTERRUPTED"

    .line 57
    .line 58
    return-object p0

    .line 59
    :pswitch_a
    const-string p0, "ERROR"

    .line 60
    .line 61
    return-object p0

    .line 62
    :pswitch_b
    const-string p0, "DEVELOPER_ERROR"

    .line 63
    .line 64
    return-object p0

    .line 65
    :pswitch_c
    const-string p0, "INTERNAL_ERROR"

    .line 66
    .line 67
    return-object p0

    .line 68
    :pswitch_d
    const-string p0, "NETWORK_ERROR"

    .line 69
    .line 70
    return-object p0

    .line 71
    :pswitch_e
    const-string p0, "RESOLUTION_REQUIRED"

    .line 72
    .line 73
    return-object p0

    .line 74
    :pswitch_f
    const-string p0, "INVALID_ACCOUNT"

    .line 75
    .line 76
    return-object p0

    .line 77
    :pswitch_10
    const-string p0, "SIGN_IN_REQUIRED"

    .line 78
    .line 79
    return-object p0

    .line 80
    :pswitch_11
    const-string p0, "SERVICE_DISABLED"

    .line 81
    .line 82
    return-object p0

    .line 83
    :pswitch_12
    const-string p0, "SERVICE_VERSION_UPDATE_REQUIRED"

    .line 84
    .line 85
    return-object p0

    .line 86
    :pswitch_13
    const-string p0, "SUCCESS"

    .line 87
    .line 88
    return-object p0

    .line 89
    :pswitch_14
    const-string p0, "SUCCESS_CACHE"

    .line 90
    .line 91
    return-object p0

    .line 92
    nop

    .line 93
    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_14
        :pswitch_13
        :pswitch_0
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_0
        :pswitch_b
        :pswitch_0
        :pswitch_0
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
.end method
