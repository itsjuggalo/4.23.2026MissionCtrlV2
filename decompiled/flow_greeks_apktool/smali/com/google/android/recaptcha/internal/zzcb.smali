.class public final Lcom/google/android/recaptcha/internal/zzcb;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field private zza:Ljava/lang/Object;

.field private final zzb:Lwg/a;


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lcom/google/android/recaptcha/internal/zzcb;->zza:Ljava/lang/Object;

    .line 5
    .line 6
    const/4 p1, 0x1

    .line 7
    const/4 v0, 0x0

    .line 8
    const/4 v1, 0x0

    .line 9
    invoke-static {v1, p1, v0}, Lwg/g;->b(ZILjava/lang/Object;)Lwg/a;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    iput-object p1, p0, Lcom/google/android/recaptcha/internal/zzcb;->zzb:Lwg/a;

    .line 14
    .line 15
    return-void
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method


# virtual methods
.method public final zza(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;
    .locals 5

    .line 1
    instance-of v0, p2, Lcom/google/android/recaptcha/internal/zzby;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    move-object v0, p2

    .line 6
    check-cast v0, Lcom/google/android/recaptcha/internal/zzby;

    .line 7
    .line 8
    iget v1, v0, Lcom/google/android/recaptcha/internal/zzby;->zzd:I

    .line 9
    .line 10
    const/high16 v2, -0x80000000

    .line 11
    .line 12
    and-int v3, v1, v2

    .line 13
    .line 14
    if-eqz v3, :cond_0

    .line 15
    .line 16
    sub-int/2addr v1, v2

    .line 17
    iput v1, v0, Lcom/google/android/recaptcha/internal/zzby;->zzd:I

    .line 18
    .line 19
    goto :goto_0

    .line 20
    :cond_0
    new-instance v0, Lcom/google/android/recaptcha/internal/zzby;

    .line 21
    .line 22
    invoke-direct {v0, p0, p2}, Lcom/google/android/recaptcha/internal/zzby;-><init>(Lcom/google/android/recaptcha/internal/zzcb;Lgd/e;)V

    .line 23
    .line 24
    .line 25
    :goto_0
    iget-object p2, v0, Lcom/google/android/recaptcha/internal/zzby;->zzb:Ljava/lang/Object;

    .line 26
    .line 27
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    iget v2, v0, Lcom/google/android/recaptcha/internal/zzby;->zzd:I

    .line 32
    .line 33
    const/4 v3, 0x1

    .line 34
    const/4 v4, 0x0

    .line 35
    if-eqz v2, :cond_2

    .line 36
    .line 37
    if-ne v2, v3, :cond_1

    .line 38
    .line 39
    iget-object p1, v0, Lcom/google/android/recaptcha/internal/zzby;->zza:Ljava/lang/Object;

    .line 40
    .line 41
    check-cast p1, Lwg/a;

    .line 42
    .line 43
    iget-object v1, v0, Lcom/google/android/recaptcha/internal/zzby;->zzf:Lcom/google/android/recaptcha/internal/zzje;

    .line 44
    .line 45
    iget-object v0, v0, Lcom/google/android/recaptcha/internal/zzby;->zze:Lcom/google/android/recaptcha/internal/zzcb;

    .line 46
    .line 47
    invoke-static {p2}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 48
    .line 49
    .line 50
    move-object p2, p1

    .line 51
    move-object p1, v1

    .line 52
    goto :goto_1

    .line 53
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 54
    .line 55
    const-string p2, "call to \'resume\' before \'invoke\' with coroutine"

    .line 56
    .line 57
    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 58
    .line 59
    .line 60
    throw p1

    .line 61
    :cond_2
    invoke-static {p2}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 62
    .line 63
    .line 64
    iget-object p2, p0, Lcom/google/android/recaptcha/internal/zzcb;->zzb:Lwg/a;

    .line 65
    .line 66
    iput-object p0, v0, Lcom/google/android/recaptcha/internal/zzby;->zze:Lcom/google/android/recaptcha/internal/zzcb;

    .line 67
    .line 68
    move-object v2, p1

    .line 69
    check-cast v2, Lcom/google/android/recaptcha/internal/zzje;

    .line 70
    .line 71
    iput-object v2, v0, Lcom/google/android/recaptcha/internal/zzby;->zzf:Lcom/google/android/recaptcha/internal/zzje;

    .line 72
    .line 73
    iput-object p2, v0, Lcom/google/android/recaptcha/internal/zzby;->zza:Ljava/lang/Object;

    .line 74
    .line 75
    iput v3, v0, Lcom/google/android/recaptcha/internal/zzby;->zzd:I

    .line 76
    .line 77
    invoke-interface {p2, v4, v0}, Lwg/a;->d(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;

    .line 78
    .line 79
    .line 80
    move-result-object v0

    .line 81
    if-eq v0, v1, :cond_3

    .line 82
    .line 83
    move-object v0, p0

    .line 84
    :goto_1
    :try_start_0
    iget-object v0, v0, Lcom/google/android/recaptcha/internal/zzcb;->zza:Ljava/lang/Object;

    .line 85
    .line 86
    invoke-static {v0, p1}, Lkotlin/jvm/internal/t;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 87
    .line 88
    .line 89
    move-result p1

    .line 90
    invoke-static {p1}, Lid/b;->a(Z)Ljava/lang/Boolean;

    .line 91
    .line 92
    .line 93
    move-result-object p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 94
    invoke-interface {p2, v4}, Lwg/a;->c(Ljava/lang/Object;)V

    .line 95
    .line 96
    .line 97
    return-object p1

    .line 98
    :catchall_0
    move-exception p1

    .line 99
    invoke-interface {p2, v4}, Lwg/a;->c(Ljava/lang/Object;)V

    .line 100
    .line 101
    .line 102
    throw p1

    .line 103
    :cond_3
    return-object v1
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
.end method

.method public final zzb([Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;
    .locals 5

    .line 1
    instance-of v0, p2, Lcom/google/android/recaptcha/internal/zzbz;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    move-object v0, p2

    .line 6
    check-cast v0, Lcom/google/android/recaptcha/internal/zzbz;

    .line 7
    .line 8
    iget v1, v0, Lcom/google/android/recaptcha/internal/zzbz;->zzd:I

    .line 9
    .line 10
    const/high16 v2, -0x80000000

    .line 11
    .line 12
    and-int v3, v1, v2

    .line 13
    .line 14
    if-eqz v3, :cond_0

    .line 15
    .line 16
    sub-int/2addr v1, v2

    .line 17
    iput v1, v0, Lcom/google/android/recaptcha/internal/zzbz;->zzd:I

    .line 18
    .line 19
    goto :goto_0

    .line 20
    :cond_0
    new-instance v0, Lcom/google/android/recaptcha/internal/zzbz;

    .line 21
    .line 22
    invoke-direct {v0, p0, p2}, Lcom/google/android/recaptcha/internal/zzbz;-><init>(Lcom/google/android/recaptcha/internal/zzcb;Lgd/e;)V

    .line 23
    .line 24
    .line 25
    :goto_0
    iget-object p2, v0, Lcom/google/android/recaptcha/internal/zzbz;->zzb:Ljava/lang/Object;

    .line 26
    .line 27
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    iget v2, v0, Lcom/google/android/recaptcha/internal/zzbz;->zzd:I

    .line 32
    .line 33
    const/4 v3, 0x1

    .line 34
    const/4 v4, 0x0

    .line 35
    if-eqz v2, :cond_2

    .line 36
    .line 37
    if-ne v2, v3, :cond_1

    .line 38
    .line 39
    iget-object p1, v0, Lcom/google/android/recaptcha/internal/zzbz;->zza:Ljava/lang/Object;

    .line 40
    .line 41
    check-cast p1, Lwg/a;

    .line 42
    .line 43
    iget-object v1, v0, Lcom/google/android/recaptcha/internal/zzbz;->zzf:[Lcom/google/android/recaptcha/internal/zzje;

    .line 44
    .line 45
    iget-object v0, v0, Lcom/google/android/recaptcha/internal/zzbz;->zze:Lcom/google/android/recaptcha/internal/zzcb;

    .line 46
    .line 47
    invoke-static {p2}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 48
    .line 49
    .line 50
    move-object p2, p1

    .line 51
    move-object p1, v1

    .line 52
    goto :goto_1

    .line 53
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 54
    .line 55
    const-string p2, "call to \'resume\' before \'invoke\' with coroutine"

    .line 56
    .line 57
    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 58
    .line 59
    .line 60
    throw p1

    .line 61
    :cond_2
    invoke-static {p2}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 62
    .line 63
    .line 64
    iget-object p2, p0, Lcom/google/android/recaptcha/internal/zzcb;->zzb:Lwg/a;

    .line 65
    .line 66
    iput-object p0, v0, Lcom/google/android/recaptcha/internal/zzbz;->zze:Lcom/google/android/recaptcha/internal/zzcb;

    .line 67
    .line 68
    move-object v2, p1

    .line 69
    check-cast v2, [Lcom/google/android/recaptcha/internal/zzje;

    .line 70
    .line 71
    iput-object v2, v0, Lcom/google/android/recaptcha/internal/zzbz;->zzf:[Lcom/google/android/recaptcha/internal/zzje;

    .line 72
    .line 73
    iput-object p2, v0, Lcom/google/android/recaptcha/internal/zzbz;->zza:Ljava/lang/Object;

    .line 74
    .line 75
    iput v3, v0, Lcom/google/android/recaptcha/internal/zzbz;->zzd:I

    .line 76
    .line 77
    invoke-interface {p2, v4, v0}, Lwg/a;->d(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;

    .line 78
    .line 79
    .line 80
    move-result-object v0

    .line 81
    if-eq v0, v1, :cond_3

    .line 82
    .line 83
    move-object v0, p0

    .line 84
    :goto_1
    :try_start_0
    iget-object v0, v0, Lcom/google/android/recaptcha/internal/zzcb;->zza:Ljava/lang/Object;

    .line 85
    .line 86
    invoke-static {p1, v0}, Ldd/n;->x([Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 87
    .line 88
    .line 89
    move-result p1

    .line 90
    invoke-static {p1}, Lid/b;->a(Z)Ljava/lang/Boolean;

    .line 91
    .line 92
    .line 93
    move-result-object p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 94
    invoke-interface {p2, v4}, Lwg/a;->c(Ljava/lang/Object;)V

    .line 95
    .line 96
    .line 97
    return-object p1

    .line 98
    :catchall_0
    move-exception p1

    .line 99
    invoke-interface {p2, v4}, Lwg/a;->c(Ljava/lang/Object;)V

    .line 100
    .line 101
    .line 102
    throw p1

    .line 103
    :cond_3
    return-object v1
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
.end method

.method public final zzc(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;
    .locals 5

    .line 1
    instance-of v0, p2, Lcom/google/android/recaptcha/internal/zzca;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    move-object v0, p2

    .line 6
    check-cast v0, Lcom/google/android/recaptcha/internal/zzca;

    .line 7
    .line 8
    iget v1, v0, Lcom/google/android/recaptcha/internal/zzca;->zzd:I

    .line 9
    .line 10
    const/high16 v2, -0x80000000

    .line 11
    .line 12
    and-int v3, v1, v2

    .line 13
    .line 14
    if-eqz v3, :cond_0

    .line 15
    .line 16
    sub-int/2addr v1, v2

    .line 17
    iput v1, v0, Lcom/google/android/recaptcha/internal/zzca;->zzd:I

    .line 18
    .line 19
    goto :goto_0

    .line 20
    :cond_0
    new-instance v0, Lcom/google/android/recaptcha/internal/zzca;

    .line 21
    .line 22
    invoke-direct {v0, p0, p2}, Lcom/google/android/recaptcha/internal/zzca;-><init>(Lcom/google/android/recaptcha/internal/zzcb;Lgd/e;)V

    .line 23
    .line 24
    .line 25
    :goto_0
    iget-object p2, v0, Lcom/google/android/recaptcha/internal/zzca;->zzb:Ljava/lang/Object;

    .line 26
    .line 27
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    iget v2, v0, Lcom/google/android/recaptcha/internal/zzca;->zzd:I

    .line 32
    .line 33
    const/4 v3, 0x1

    .line 34
    const/4 v4, 0x0

    .line 35
    if-eqz v2, :cond_2

    .line 36
    .line 37
    if-ne v2, v3, :cond_1

    .line 38
    .line 39
    iget-object p1, v0, Lcom/google/android/recaptcha/internal/zzca;->zza:Ljava/lang/Object;

    .line 40
    .line 41
    check-cast p1, Lwg/a;

    .line 42
    .line 43
    iget-object v1, v0, Lcom/google/android/recaptcha/internal/zzca;->zzf:Lcom/google/android/recaptcha/internal/zzje;

    .line 44
    .line 45
    iget-object v0, v0, Lcom/google/android/recaptcha/internal/zzca;->zze:Lcom/google/android/recaptcha/internal/zzcb;

    .line 46
    .line 47
    invoke-static {p2}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 48
    .line 49
    .line 50
    move-object p2, p1

    .line 51
    move-object p1, v1

    .line 52
    goto :goto_1

    .line 53
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 54
    .line 55
    const-string p2, "call to \'resume\' before \'invoke\' with coroutine"

    .line 56
    .line 57
    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 58
    .line 59
    .line 60
    throw p1

    .line 61
    :cond_2
    invoke-static {p2}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 62
    .line 63
    .line 64
    iget-object p2, p0, Lcom/google/android/recaptcha/internal/zzcb;->zzb:Lwg/a;

    .line 65
    .line 66
    iput-object p0, v0, Lcom/google/android/recaptcha/internal/zzca;->zze:Lcom/google/android/recaptcha/internal/zzcb;

    .line 67
    .line 68
    move-object v2, p1

    .line 69
    check-cast v2, Lcom/google/android/recaptcha/internal/zzje;

    .line 70
    .line 71
    iput-object v2, v0, Lcom/google/android/recaptcha/internal/zzca;->zzf:Lcom/google/android/recaptcha/internal/zzje;

    .line 72
    .line 73
    iput-object p2, v0, Lcom/google/android/recaptcha/internal/zzca;->zza:Ljava/lang/Object;

    .line 74
    .line 75
    iput v3, v0, Lcom/google/android/recaptcha/internal/zzca;->zzd:I

    .line 76
    .line 77
    invoke-interface {p2, v4, v0}, Lwg/a;->d(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;

    .line 78
    .line 79
    .line 80
    move-result-object v0

    .line 81
    if-eq v0, v1, :cond_3

    .line 82
    .line 83
    move-object v0, p0

    .line 84
    :goto_1
    :try_start_0
    iput-object p1, v0, Lcom/google/android/recaptcha/internal/zzcb;->zza:Ljava/lang/Object;

    .line 85
    .line 86
    sget-object p1, Lcd/h0;->a:Lcd/h0;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 87
    .line 88
    invoke-interface {p2, v4}, Lwg/a;->c(Ljava/lang/Object;)V

    .line 89
    .line 90
    .line 91
    sget-object p1, Lcd/h0;->a:Lcd/h0;

    .line 92
    .line 93
    return-object p1

    .line 94
    :catchall_0
    move-exception p1

    .line 95
    invoke-interface {p2, v4}, Lwg/a;->c(Ljava/lang/Object;)V

    .line 96
    .line 97
    .line 98
    throw p1

    .line 99
    :cond_3
    return-object v1
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
.end method
