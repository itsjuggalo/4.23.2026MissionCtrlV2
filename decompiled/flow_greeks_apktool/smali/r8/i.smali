.class public Lr8/i;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Iterable;


# static fields
.field public static final d:Lg8/e;


# instance fields
.field public final a:Lr8/n;

.field public b:Lg8/e;

.field public final c:Lr8/h;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lg8/e;

    .line 2
    .line 3
    sget-object v1, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    invoke-direct {v0, v1, v2}, Lg8/e;-><init>(Ljava/util/List;Ljava/util/Comparator;)V

    .line 7
    .line 8
    .line 9
    sput-object v0, Lr8/i;->d:Lg8/e;

    .line 10
    .line 11
    return-void
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public constructor <init>(Lr8/n;Lr8/h;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p2, p0, Lr8/i;->c:Lr8/h;

    .line 3
    iput-object p1, p0, Lr8/i;->a:Lr8/n;

    const/4 p1, 0x0

    .line 4
    iput-object p1, p0, Lr8/i;->b:Lg8/e;

    return-void
.end method

.method public constructor <init>(Lr8/n;Lr8/h;Lg8/e;)V
    .locals 0

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    iput-object p2, p0, Lr8/i;->c:Lr8/h;

    .line 7
    iput-object p1, p0, Lr8/i;->a:Lr8/n;

    .line 8
    iput-object p3, p0, Lr8/i;->b:Lg8/e;

    return-void
.end method

.method public static c(Lr8/n;)Lr8/i;
    .locals 2

    .line 1
    new-instance v0, Lr8/i;

    .line 2
    .line 3
    invoke-static {}, Lr8/q;->j()Lr8/q;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    invoke-direct {v0, p0, v1}, Lr8/i;-><init>(Lr8/n;Lr8/h;)V

    .line 8
    .line 9
    .line 10
    return-object v0
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
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

.method public static d(Lr8/n;Lr8/h;)Lr8/i;
    .locals 1

    .line 1
    new-instance v0, Lr8/i;

    .line 2
    .line 3
    invoke-direct {v0, p0, p1}, Lr8/i;-><init>(Lr8/n;Lr8/h;)V

    .line 4
    .line 5
    .line 6
    return-object v0
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method


# virtual methods
.method public P()Ljava/util/Iterator;
    .locals 2

    .line 1
    invoke-virtual {p0}, Lr8/i;->a()V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 5
    .line 6
    sget-object v1, Lr8/i;->d:Lg8/e;

    .line 7
    .line 8
    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/q;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 9
    .line 10
    .line 11
    move-result v0

    .line 12
    if-eqz v0, :cond_0

    .line 13
    .line 14
    iget-object v0, p0, Lr8/i;->a:Lr8/n;

    .line 15
    .line 16
    invoke-interface {v0}, Lr8/n;->P()Ljava/util/Iterator;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    return-object v0

    .line 21
    :cond_0
    iget-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 22
    .line 23
    invoke-virtual {v0}, Lg8/e;->P()Ljava/util/Iterator;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    return-object v0
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
.end method

.method public final a()V
    .locals 7

    .line 1
    iget-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 2
    .line 3
    if-nez v0, :cond_5

    .line 4
    .line 5
    iget-object v0, p0, Lr8/i;->c:Lr8/h;

    .line 6
    .line 7
    invoke-static {}, Lr8/j;->j()Lr8/j;

    .line 8
    .line 9
    .line 10
    move-result-object v1

    .line 11
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 12
    .line 13
    .line 14
    move-result v0

    .line 15
    if-eqz v0, :cond_0

    .line 16
    .line 17
    sget-object v0, Lr8/i;->d:Lg8/e;

    .line 18
    .line 19
    iput-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 20
    .line 21
    return-void

    .line 22
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    .line 23
    .line 24
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 25
    .line 26
    .line 27
    iget-object v1, p0, Lr8/i;->a:Lr8/n;

    .line 28
    .line 29
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 30
    .line 31
    .line 32
    move-result-object v1

    .line 33
    const/4 v2, 0x0

    .line 34
    move v3, v2

    .line 35
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    .line 36
    .line 37
    .line 38
    move-result v4

    .line 39
    if-eqz v4, :cond_3

    .line 40
    .line 41
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 42
    .line 43
    .line 44
    move-result-object v4

    .line 45
    check-cast v4, Lr8/m;

    .line 46
    .line 47
    if-nez v3, :cond_2

    .line 48
    .line 49
    iget-object v3, p0, Lr8/i;->c:Lr8/h;

    .line 50
    .line 51
    invoke-virtual {v4}, Lr8/m;->d()Lr8/n;

    .line 52
    .line 53
    .line 54
    move-result-object v5

    .line 55
    invoke-virtual {v3, v5}, Lr8/h;->e(Lr8/n;)Z

    .line 56
    .line 57
    .line 58
    move-result v3

    .line 59
    if-eqz v3, :cond_1

    .line 60
    .line 61
    goto :goto_1

    .line 62
    :cond_1
    move v3, v2

    .line 63
    goto :goto_2

    .line 64
    :cond_2
    :goto_1
    const/4 v3, 0x1

    .line 65
    :goto_2
    new-instance v5, Lr8/m;

    .line 66
    .line 67
    invoke-virtual {v4}, Lr8/m;->c()Lr8/b;

    .line 68
    .line 69
    .line 70
    move-result-object v6

    .line 71
    invoke-virtual {v4}, Lr8/m;->d()Lr8/n;

    .line 72
    .line 73
    .line 74
    move-result-object v4

    .line 75
    invoke-direct {v5, v6, v4}, Lr8/m;-><init>(Lr8/b;Lr8/n;)V

    .line 76
    .line 77
    .line 78
    invoke-interface {v0, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 79
    .line 80
    .line 81
    goto :goto_0

    .line 82
    :cond_3
    if-eqz v3, :cond_4

    .line 83
    .line 84
    new-instance v1, Lg8/e;

    .line 85
    .line 86
    iget-object v2, p0, Lr8/i;->c:Lr8/h;

    .line 87
    .line 88
    invoke-direct {v1, v0, v2}, Lg8/e;-><init>(Ljava/util/List;Ljava/util/Comparator;)V

    .line 89
    .line 90
    .line 91
    iput-object v1, p0, Lr8/i;->b:Lg8/e;

    .line 92
    .line 93
    return-void

    .line 94
    :cond_4
    sget-object v0, Lr8/i;->d:Lg8/e;

    .line 95
    .line 96
    iput-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 97
    .line 98
    :cond_5
    return-void
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
.end method

.method public e()Lr8/m;
    .locals 3

    .line 1
    iget-object v0, p0, Lr8/i;->a:Lr8/n;

    .line 2
    .line 3
    instance-of v0, v0, Lr8/c;

    .line 4
    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x0

    .line 8
    return-object v0

    .line 9
    :cond_0
    invoke-virtual {p0}, Lr8/i;->a()V

    .line 10
    .line 11
    .line 12
    iget-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 13
    .line 14
    sget-object v1, Lr8/i;->d:Lg8/e;

    .line 15
    .line 16
    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/q;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 17
    .line 18
    .line 19
    move-result v0

    .line 20
    if-eqz v0, :cond_1

    .line 21
    .line 22
    iget-object v0, p0, Lr8/i;->a:Lr8/n;

    .line 23
    .line 24
    check-cast v0, Lr8/c;

    .line 25
    .line 26
    invoke-virtual {v0}, Lr8/c;->u()Lr8/b;

    .line 27
    .line 28
    .line 29
    move-result-object v0

    .line 30
    new-instance v1, Lr8/m;

    .line 31
    .line 32
    iget-object v2, p0, Lr8/i;->a:Lr8/n;

    .line 33
    .line 34
    invoke-interface {v2, v0}, Lr8/n;->z(Lr8/b;)Lr8/n;

    .line 35
    .line 36
    .line 37
    move-result-object v2

    .line 38
    invoke-direct {v1, v0, v2}, Lr8/m;-><init>(Lr8/b;Lr8/n;)V

    .line 39
    .line 40
    .line 41
    return-object v1

    .line 42
    :cond_1
    iget-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 43
    .line 44
    invoke-virtual {v0}, Lg8/e;->c()Ljava/lang/Object;

    .line 45
    .line 46
    .line 47
    move-result-object v0

    .line 48
    check-cast v0, Lr8/m;

    .line 49
    .line 50
    return-object v0
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
.end method

.method public f()Lr8/m;
    .locals 3

    .line 1
    iget-object v0, p0, Lr8/i;->a:Lr8/n;

    .line 2
    .line 3
    instance-of v0, v0, Lr8/c;

    .line 4
    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x0

    .line 8
    return-object v0

    .line 9
    :cond_0
    invoke-virtual {p0}, Lr8/i;->a()V

    .line 10
    .line 11
    .line 12
    iget-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 13
    .line 14
    sget-object v1, Lr8/i;->d:Lg8/e;

    .line 15
    .line 16
    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/q;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 17
    .line 18
    .line 19
    move-result v0

    .line 20
    if-eqz v0, :cond_1

    .line 21
    .line 22
    iget-object v0, p0, Lr8/i;->a:Lr8/n;

    .line 23
    .line 24
    check-cast v0, Lr8/c;

    .line 25
    .line 26
    invoke-virtual {v0}, Lr8/c;->v()Lr8/b;

    .line 27
    .line 28
    .line 29
    move-result-object v0

    .line 30
    new-instance v1, Lr8/m;

    .line 31
    .line 32
    iget-object v2, p0, Lr8/i;->a:Lr8/n;

    .line 33
    .line 34
    invoke-interface {v2, v0}, Lr8/n;->z(Lr8/b;)Lr8/n;

    .line 35
    .line 36
    .line 37
    move-result-object v2

    .line 38
    invoke-direct {v1, v0, v2}, Lr8/m;-><init>(Lr8/b;Lr8/n;)V

    .line 39
    .line 40
    .line 41
    return-object v1

    .line 42
    :cond_1
    iget-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 43
    .line 44
    invoke-virtual {v0}, Lg8/e;->a()Ljava/lang/Object;

    .line 45
    .line 46
    .line 47
    move-result-object v0

    .line 48
    check-cast v0, Lr8/m;

    .line 49
    .line 50
    return-object v0
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
.end method

.method public g()Lr8/n;
    .locals 1

    .line 1
    iget-object v0, p0, Lr8/i;->a:Lr8/n;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 2

    .line 1
    invoke-virtual {p0}, Lr8/i;->a()V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 5
    .line 6
    sget-object v1, Lr8/i;->d:Lg8/e;

    .line 7
    .line 8
    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/q;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 9
    .line 10
    .line 11
    move-result v0

    .line 12
    if-eqz v0, :cond_0

    .line 13
    .line 14
    iget-object v0, p0, Lr8/i;->a:Lr8/n;

    .line 15
    .line 16
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    return-object v0

    .line 21
    :cond_0
    iget-object v0, p0, Lr8/i;->b:Lg8/e;

    .line 22
    .line 23
    invoke-virtual {v0}, Lg8/e;->iterator()Ljava/util/Iterator;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    return-object v0
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
.end method

.method public p(Lr8/b;Lr8/n;Lr8/h;)Lr8/b;
    .locals 2

    .line 1
    iget-object v0, p0, Lr8/i;->c:Lr8/h;

    .line 2
    .line 3
    invoke-static {}, Lr8/j;->j()Lr8/j;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-nez v0, :cond_1

    .line 12
    .line 13
    iget-object v0, p0, Lr8/i;->c:Lr8/h;

    .line 14
    .line 15
    invoke-virtual {v0, p3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 16
    .line 17
    .line 18
    move-result p3

    .line 19
    if-eqz p3, :cond_0

    .line 20
    .line 21
    goto :goto_0

    .line 22
    :cond_0
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 23
    .line 24
    const-string p2, "Index not available in IndexedNode!"

    .line 25
    .line 26
    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 27
    .line 28
    .line 29
    throw p1

    .line 30
    :cond_1
    :goto_0
    invoke-virtual {p0}, Lr8/i;->a()V

    .line 31
    .line 32
    .line 33
    iget-object p3, p0, Lr8/i;->b:Lg8/e;

    .line 34
    .line 35
    sget-object v0, Lr8/i;->d:Lg8/e;

    .line 36
    .line 37
    invoke-static {p3, v0}, Lcom/google/android/gms/common/internal/q;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 38
    .line 39
    .line 40
    move-result p3

    .line 41
    if-eqz p3, :cond_2

    .line 42
    .line 43
    iget-object p2, p0, Lr8/i;->a:Lr8/n;

    .line 44
    .line 45
    invoke-interface {p2, p1}, Lr8/n;->x(Lr8/b;)Lr8/b;

    .line 46
    .line 47
    .line 48
    move-result-object p1

    .line 49
    return-object p1

    .line 50
    :cond_2
    iget-object p3, p0, Lr8/i;->b:Lg8/e;

    .line 51
    .line 52
    new-instance v0, Lr8/m;

    .line 53
    .line 54
    invoke-direct {v0, p1, p2}, Lr8/m;-><init>(Lr8/b;Lr8/n;)V

    .line 55
    .line 56
    .line 57
    invoke-virtual {p3, v0}, Lg8/e;->d(Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    .line 59
    .line 60
    move-result-object p1

    .line 61
    check-cast p1, Lr8/m;

    .line 62
    .line 63
    if-eqz p1, :cond_3

    .line 64
    .line 65
    invoke-virtual {p1}, Lr8/m;->c()Lr8/b;

    .line 66
    .line 67
    .line 68
    move-result-object p1

    .line 69
    return-object p1

    .line 70
    :cond_3
    const/4 p1, 0x0

    .line 71
    return-object p1
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
.end method

.method public q(Lr8/h;)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lr8/i;->c:Lr8/h;

    .line 2
    .line 3
    if-ne v0, p1, :cond_0

    .line 4
    .line 5
    const/4 p1, 0x1

    .line 6
    return p1

    .line 7
    :cond_0
    const/4 p1, 0x0

    .line 8
    return p1
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
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

.method public r(Lr8/b;Lr8/n;)Lr8/i;
    .locals 4

    .line 1
    iget-object v0, p0, Lr8/i;->a:Lr8/n;

    .line 2
    .line 3
    invoke-interface {v0, p1, p2}, Lr8/n;->t(Lr8/b;Lr8/n;)Lr8/n;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v1, p0, Lr8/i;->b:Lg8/e;

    .line 8
    .line 9
    sget-object v2, Lr8/i;->d:Lg8/e;

    .line 10
    .line 11
    invoke-static {v1, v2}, Lcom/google/android/gms/common/internal/q;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    if-eqz v1, :cond_0

    .line 16
    .line 17
    iget-object v1, p0, Lr8/i;->c:Lr8/h;

    .line 18
    .line 19
    invoke-virtual {v1, p2}, Lr8/h;->e(Lr8/n;)Z

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    if-nez v1, :cond_0

    .line 24
    .line 25
    new-instance p1, Lr8/i;

    .line 26
    .line 27
    iget-object p2, p0, Lr8/i;->c:Lr8/h;

    .line 28
    .line 29
    invoke-direct {p1, v0, p2, v2}, Lr8/i;-><init>(Lr8/n;Lr8/h;Lg8/e;)V

    .line 30
    .line 31
    .line 32
    return-object p1

    .line 33
    :cond_0
    iget-object v1, p0, Lr8/i;->b:Lg8/e;

    .line 34
    .line 35
    if-eqz v1, :cond_3

    .line 36
    .line 37
    invoke-static {v1, v2}, Lcom/google/android/gms/common/internal/q;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 38
    .line 39
    .line 40
    move-result v1

    .line 41
    if-eqz v1, :cond_1

    .line 42
    .line 43
    goto :goto_0

    .line 44
    :cond_1
    iget-object v1, p0, Lr8/i;->a:Lr8/n;

    .line 45
    .line 46
    invoke-interface {v1, p1}, Lr8/n;->z(Lr8/b;)Lr8/n;

    .line 47
    .line 48
    .line 49
    move-result-object v1

    .line 50
    iget-object v2, p0, Lr8/i;->b:Lg8/e;

    .line 51
    .line 52
    new-instance v3, Lr8/m;

    .line 53
    .line 54
    invoke-direct {v3, p1, v1}, Lr8/m;-><init>(Lr8/b;Lr8/n;)V

    .line 55
    .line 56
    .line 57
    invoke-virtual {v2, v3}, Lg8/e;->g(Ljava/lang/Object;)Lg8/e;

    .line 58
    .line 59
    .line 60
    move-result-object v1

    .line 61
    invoke-interface {p2}, Lr8/n;->isEmpty()Z

    .line 62
    .line 63
    .line 64
    move-result v2

    .line 65
    if-nez v2, :cond_2

    .line 66
    .line 67
    new-instance v2, Lr8/m;

    .line 68
    .line 69
    invoke-direct {v2, p1, p2}, Lr8/m;-><init>(Lr8/b;Lr8/n;)V

    .line 70
    .line 71
    .line 72
    invoke-virtual {v1, v2}, Lg8/e;->e(Ljava/lang/Object;)Lg8/e;

    .line 73
    .line 74
    .line 75
    move-result-object v1

    .line 76
    :cond_2
    new-instance p1, Lr8/i;

    .line 77
    .line 78
    iget-object p2, p0, Lr8/i;->c:Lr8/h;

    .line 79
    .line 80
    invoke-direct {p1, v0, p2, v1}, Lr8/i;-><init>(Lr8/n;Lr8/h;Lg8/e;)V

    .line 81
    .line 82
    .line 83
    return-object p1

    .line 84
    :cond_3
    :goto_0
    new-instance p1, Lr8/i;

    .line 85
    .line 86
    iget-object p2, p0, Lr8/i;->c:Lr8/h;

    .line 87
    .line 88
    const/4 v1, 0x0

    .line 89
    invoke-direct {p1, v0, p2, v1}, Lr8/i;-><init>(Lr8/n;Lr8/h;Lg8/e;)V

    .line 90
    .line 91
    .line 92
    return-object p1
    .line 93
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
.end method

.method public s(Lr8/n;)Lr8/i;
    .locals 3

    .line 1
    new-instance v0, Lr8/i;

    .line 2
    .line 3
    iget-object v1, p0, Lr8/i;->a:Lr8/n;

    .line 4
    .line 5
    invoke-interface {v1, p1}, Lr8/n;->D(Lr8/n;)Lr8/n;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    iget-object v1, p0, Lr8/i;->c:Lr8/h;

    .line 10
    .line 11
    iget-object v2, p0, Lr8/i;->b:Lg8/e;

    .line 12
    .line 13
    invoke-direct {v0, p1, v1, v2}, Lr8/i;-><init>(Lr8/n;Lr8/h;Lg8/e;)V

    .line 14
    .line 15
    .line 16
    return-object v0
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method
