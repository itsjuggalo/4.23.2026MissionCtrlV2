.class public final Li9/n4;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final a:Lg9/g1;

.field public final b:I

.field public final c:J

.field public final d:Li9/k1;

.field public final e:Lj9/v;

.field public final f:Lj9/v;

.field public final g:Lcom/google/protobuf/i;

.field public final h:Ljava/lang/Integer;


# direct methods
.method public constructor <init>(Lg9/g1;IJLi9/k1;)V
    .locals 10

    .line 10
    sget-object v6, Lj9/v;->b:Lj9/v;

    sget-object v8, Lm9/a1;->t:Lcom/google/protobuf/i;

    const/4 v9, 0x0

    move-object v7, v6

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-wide v3, p3

    move-object v5, p5

    invoke-direct/range {v0 .. v9}, Li9/n4;-><init>(Lg9/g1;IJLi9/k1;Lj9/v;Lj9/v;Lcom/google/protobuf/i;Ljava/lang/Integer;)V

    return-void
.end method

.method public constructor <init>(Lg9/g1;IJLi9/k1;Lj9/v;Lj9/v;Lcom/google/protobuf/i;Ljava/lang/Integer;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    invoke-static {p1}, Ln9/x;->b(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lg9/g1;

    iput-object p1, p0, Li9/n4;->a:Lg9/g1;

    .line 3
    iput p2, p0, Li9/n4;->b:I

    .line 4
    iput-wide p3, p0, Li9/n4;->c:J

    .line 5
    iput-object p7, p0, Li9/n4;->f:Lj9/v;

    .line 6
    iput-object p5, p0, Li9/n4;->d:Li9/k1;

    .line 7
    invoke-static {p6}, Ln9/x;->b(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lj9/v;

    iput-object p1, p0, Li9/n4;->e:Lj9/v;

    .line 8
    invoke-static {p8}, Ln9/x;->b(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/protobuf/i;

    iput-object p1, p0, Li9/n4;->g:Lcom/google/protobuf/i;

    .line 9
    iput-object p9, p0, Li9/n4;->h:Ljava/lang/Integer;

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/Integer;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/n4;->h:Ljava/lang/Integer;

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

.method public b()Lj9/v;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/n4;->f:Lj9/v;

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

.method public c()Li9/k1;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/n4;->d:Li9/k1;

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

.method public d()Lcom/google/protobuf/i;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/n4;->g:Lcom/google/protobuf/i;

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

.method public e()J
    .locals 2

    .line 1
    iget-wide v0, p0, Li9/n4;->c:J

    .line 2
    .line 3
    return-wide v0
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

.method public equals(Ljava/lang/Object;)Z
    .locals 6

    .line 1
    const/4 v0, 0x1

    .line 2
    if-ne p0, p1, :cond_0

    .line 3
    .line 4
    return v0

    .line 5
    :cond_0
    const/4 v1, 0x0

    .line 6
    if-eqz p1, :cond_2

    .line 7
    .line 8
    const-class v2, Li9/n4;

    .line 9
    .line 10
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 11
    .line 12
    .line 13
    move-result-object v3

    .line 14
    if-eq v2, v3, :cond_1

    .line 15
    .line 16
    goto :goto_0

    .line 17
    :cond_1
    check-cast p1, Li9/n4;

    .line 18
    .line 19
    iget-object v2, p0, Li9/n4;->a:Lg9/g1;

    .line 20
    .line 21
    iget-object v3, p1, Li9/n4;->a:Lg9/g1;

    .line 22
    .line 23
    invoke-virtual {v2, v3}, Lg9/g1;->equals(Ljava/lang/Object;)Z

    .line 24
    .line 25
    .line 26
    move-result v2

    .line 27
    if-eqz v2, :cond_2

    .line 28
    .line 29
    iget v2, p0, Li9/n4;->b:I

    .line 30
    .line 31
    iget v3, p1, Li9/n4;->b:I

    .line 32
    .line 33
    if-ne v2, v3, :cond_2

    .line 34
    .line 35
    iget-wide v2, p0, Li9/n4;->c:J

    .line 36
    .line 37
    iget-wide v4, p1, Li9/n4;->c:J

    .line 38
    .line 39
    cmp-long v2, v2, v4

    .line 40
    .line 41
    if-nez v2, :cond_2

    .line 42
    .line 43
    iget-object v2, p0, Li9/n4;->d:Li9/k1;

    .line 44
    .line 45
    iget-object v3, p1, Li9/n4;->d:Li9/k1;

    .line 46
    .line 47
    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 48
    .line 49
    .line 50
    move-result v2

    .line 51
    if-eqz v2, :cond_2

    .line 52
    .line 53
    iget-object v2, p0, Li9/n4;->e:Lj9/v;

    .line 54
    .line 55
    iget-object v3, p1, Li9/n4;->e:Lj9/v;

    .line 56
    .line 57
    invoke-virtual {v2, v3}, Lj9/v;->equals(Ljava/lang/Object;)Z

    .line 58
    .line 59
    .line 60
    move-result v2

    .line 61
    if-eqz v2, :cond_2

    .line 62
    .line 63
    iget-object v2, p0, Li9/n4;->f:Lj9/v;

    .line 64
    .line 65
    iget-object v3, p1, Li9/n4;->f:Lj9/v;

    .line 66
    .line 67
    invoke-virtual {v2, v3}, Lj9/v;->equals(Ljava/lang/Object;)Z

    .line 68
    .line 69
    .line 70
    move-result v2

    .line 71
    if-eqz v2, :cond_2

    .line 72
    .line 73
    iget-object v2, p0, Li9/n4;->g:Lcom/google/protobuf/i;

    .line 74
    .line 75
    iget-object v3, p1, Li9/n4;->g:Lcom/google/protobuf/i;

    .line 76
    .line 77
    invoke-virtual {v2, v3}, Lcom/google/protobuf/i;->equals(Ljava/lang/Object;)Z

    .line 78
    .line 79
    .line 80
    move-result v2

    .line 81
    if-eqz v2, :cond_2

    .line 82
    .line 83
    iget-object v2, p0, Li9/n4;->h:Ljava/lang/Integer;

    .line 84
    .line 85
    iget-object p1, p1, Li9/n4;->h:Ljava/lang/Integer;

    .line 86
    .line 87
    invoke-static {v2, p1}, Ljava/util/Objects;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 88
    .line 89
    .line 90
    move-result p1

    .line 91
    if-eqz p1, :cond_2

    .line 92
    .line 93
    return v0

    .line 94
    :cond_2
    :goto_0
    return v1
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

.method public f()Lj9/v;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/n4;->e:Lj9/v;

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

.method public g()Lg9/g1;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/n4;->a:Lg9/g1;

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

.method public h()I
    .locals 1

    .line 1
    iget v0, p0, Li9/n4;->b:I

    .line 2
    .line 3
    return v0
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

.method public hashCode()I
    .locals 3

    .line 1
    iget-object v0, p0, Li9/n4;->a:Lg9/g1;

    .line 2
    .line 3
    invoke-virtual {v0}, Lg9/g1;->hashCode()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    mul-int/lit8 v0, v0, 0x1f

    .line 8
    .line 9
    iget v1, p0, Li9/n4;->b:I

    .line 10
    .line 11
    add-int/2addr v0, v1

    .line 12
    mul-int/lit8 v0, v0, 0x1f

    .line 13
    .line 14
    iget-wide v1, p0, Li9/n4;->c:J

    .line 15
    .line 16
    long-to-int v1, v1

    .line 17
    add-int/2addr v0, v1

    .line 18
    mul-int/lit8 v0, v0, 0x1f

    .line 19
    .line 20
    iget-object v1, p0, Li9/n4;->d:Li9/k1;

    .line 21
    .line 22
    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    .line 23
    .line 24
    .line 25
    move-result v1

    .line 26
    add-int/2addr v0, v1

    .line 27
    mul-int/lit8 v0, v0, 0x1f

    .line 28
    .line 29
    iget-object v1, p0, Li9/n4;->e:Lj9/v;

    .line 30
    .line 31
    invoke-virtual {v1}, Lj9/v;->hashCode()I

    .line 32
    .line 33
    .line 34
    move-result v1

    .line 35
    add-int/2addr v0, v1

    .line 36
    mul-int/lit8 v0, v0, 0x1f

    .line 37
    .line 38
    iget-object v1, p0, Li9/n4;->f:Lj9/v;

    .line 39
    .line 40
    invoke-virtual {v1}, Lj9/v;->hashCode()I

    .line 41
    .line 42
    .line 43
    move-result v1

    .line 44
    add-int/2addr v0, v1

    .line 45
    mul-int/lit8 v0, v0, 0x1f

    .line 46
    .line 47
    iget-object v1, p0, Li9/n4;->g:Lcom/google/protobuf/i;

    .line 48
    .line 49
    invoke-virtual {v1}, Lcom/google/protobuf/i;->hashCode()I

    .line 50
    .line 51
    .line 52
    move-result v1

    .line 53
    add-int/2addr v0, v1

    .line 54
    mul-int/lit8 v0, v0, 0x1f

    .line 55
    .line 56
    iget-object v1, p0, Li9/n4;->h:Ljava/lang/Integer;

    .line 57
    .line 58
    invoke-static {v1}, Ljava/util/Objects;->hashCode(Ljava/lang/Object;)I

    .line 59
    .line 60
    .line 61
    move-result v1

    .line 62
    add-int/2addr v0, v1

    .line 63
    return v0
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
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
    .line 89
    .line 90
    .line 91
    .line 92
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

.method public i(Ljava/lang/Integer;)Li9/n4;
    .locals 10

    .line 1
    new-instance v0, Li9/n4;

    .line 2
    .line 3
    iget-object v1, p0, Li9/n4;->a:Lg9/g1;

    .line 4
    .line 5
    iget v2, p0, Li9/n4;->b:I

    .line 6
    .line 7
    iget-wide v3, p0, Li9/n4;->c:J

    .line 8
    .line 9
    iget-object v5, p0, Li9/n4;->d:Li9/k1;

    .line 10
    .line 11
    iget-object v6, p0, Li9/n4;->e:Lj9/v;

    .line 12
    .line 13
    iget-object v7, p0, Li9/n4;->f:Lj9/v;

    .line 14
    .line 15
    iget-object v8, p0, Li9/n4;->g:Lcom/google/protobuf/i;

    .line 16
    .line 17
    move-object v9, p1

    .line 18
    invoke-direct/range {v0 .. v9}, Li9/n4;-><init>(Lg9/g1;IJLi9/k1;Lj9/v;Lj9/v;Lcom/google/protobuf/i;Ljava/lang/Integer;)V

    .line 19
    .line 20
    .line 21
    return-object v0
    .line 22
    .line 23
    .line 24
.end method

.method public j(Lj9/v;)Li9/n4;
    .locals 10

    .line 1
    new-instance v0, Li9/n4;

    .line 2
    .line 3
    iget-object v1, p0, Li9/n4;->a:Lg9/g1;

    .line 4
    .line 5
    iget v2, p0, Li9/n4;->b:I

    .line 6
    .line 7
    iget-wide v3, p0, Li9/n4;->c:J

    .line 8
    .line 9
    iget-object v5, p0, Li9/n4;->d:Li9/k1;

    .line 10
    .line 11
    iget-object v6, p0, Li9/n4;->e:Lj9/v;

    .line 12
    .line 13
    iget-object v8, p0, Li9/n4;->g:Lcom/google/protobuf/i;

    .line 14
    .line 15
    iget-object v9, p0, Li9/n4;->h:Ljava/lang/Integer;

    .line 16
    .line 17
    move-object v7, p1

    .line 18
    invoke-direct/range {v0 .. v9}, Li9/n4;-><init>(Lg9/g1;IJLi9/k1;Lj9/v;Lj9/v;Lcom/google/protobuf/i;Ljava/lang/Integer;)V

    .line 19
    .line 20
    .line 21
    return-object v0
    .line 22
    .line 23
    .line 24
.end method

.method public k(Lcom/google/protobuf/i;Lj9/v;)Li9/n4;
    .locals 10

    .line 1
    new-instance v0, Li9/n4;

    .line 2
    .line 3
    iget-object v1, p0, Li9/n4;->a:Lg9/g1;

    .line 4
    .line 5
    iget v2, p0, Li9/n4;->b:I

    .line 6
    .line 7
    iget-wide v3, p0, Li9/n4;->c:J

    .line 8
    .line 9
    iget-object v5, p0, Li9/n4;->d:Li9/k1;

    .line 10
    .line 11
    iget-object v7, p0, Li9/n4;->f:Lj9/v;

    .line 12
    .line 13
    const/4 v9, 0x0

    .line 14
    move-object v8, p1

    .line 15
    move-object v6, p2

    .line 16
    invoke-direct/range {v0 .. v9}, Li9/n4;-><init>(Lg9/g1;IJLi9/k1;Lj9/v;Lj9/v;Lcom/google/protobuf/i;Ljava/lang/Integer;)V

    .line 17
    .line 18
    .line 19
    return-object v0
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

.method public l(J)Li9/n4;
    .locals 10

    .line 1
    new-instance v0, Li9/n4;

    .line 2
    .line 3
    iget-object v1, p0, Li9/n4;->a:Lg9/g1;

    .line 4
    .line 5
    iget v2, p0, Li9/n4;->b:I

    .line 6
    .line 7
    iget-object v5, p0, Li9/n4;->d:Li9/k1;

    .line 8
    .line 9
    iget-object v6, p0, Li9/n4;->e:Lj9/v;

    .line 10
    .line 11
    iget-object v7, p0, Li9/n4;->f:Lj9/v;

    .line 12
    .line 13
    iget-object v8, p0, Li9/n4;->g:Lcom/google/protobuf/i;

    .line 14
    .line 15
    iget-object v9, p0, Li9/n4;->h:Ljava/lang/Integer;

    .line 16
    .line 17
    move-wide v3, p1

    .line 18
    invoke-direct/range {v0 .. v9}, Li9/n4;-><init>(Lg9/g1;IJLi9/k1;Lj9/v;Lj9/v;Lcom/google/protobuf/i;Ljava/lang/Integer;)V

    .line 19
    .line 20
    .line 21
    return-object v0
    .line 22
    .line 23
    .line 24
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 4
    .line 5
    .line 6
    const-string v1, "TargetData{target="

    .line 7
    .line 8
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 9
    .line 10
    .line 11
    iget-object v1, p0, Li9/n4;->a:Lg9/g1;

    .line 12
    .line 13
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 14
    .line 15
    .line 16
    const-string v1, ", targetId="

    .line 17
    .line 18
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 19
    .line 20
    .line 21
    iget v1, p0, Li9/n4;->b:I

    .line 22
    .line 23
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 24
    .line 25
    .line 26
    const-string v1, ", sequenceNumber="

    .line 27
    .line 28
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 29
    .line 30
    .line 31
    iget-wide v1, p0, Li9/n4;->c:J

    .line 32
    .line 33
    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 34
    .line 35
    .line 36
    const-string v1, ", purpose="

    .line 37
    .line 38
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 39
    .line 40
    .line 41
    iget-object v1, p0, Li9/n4;->d:Li9/k1;

    .line 42
    .line 43
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 44
    .line 45
    .line 46
    const-string v1, ", snapshotVersion="

    .line 47
    .line 48
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 49
    .line 50
    .line 51
    iget-object v1, p0, Li9/n4;->e:Lj9/v;

    .line 52
    .line 53
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 54
    .line 55
    .line 56
    const-string v1, ", lastLimboFreeSnapshotVersion="

    .line 57
    .line 58
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 59
    .line 60
    .line 61
    iget-object v1, p0, Li9/n4;->f:Lj9/v;

    .line 62
    .line 63
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 64
    .line 65
    .line 66
    const-string v1, ", resumeToken="

    .line 67
    .line 68
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 69
    .line 70
    .line 71
    iget-object v1, p0, Li9/n4;->g:Lcom/google/protobuf/i;

    .line 72
    .line 73
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 74
    .line 75
    .line 76
    const-string v1, ", expectedCount="

    .line 77
    .line 78
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 79
    .line 80
    .line 81
    iget-object v1, p0, Li9/n4;->h:Ljava/lang/Integer;

    .line 82
    .line 83
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 84
    .line 85
    .line 86
    const/16 v1, 0x7d

    .line 87
    .line 88
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 89
    .line 90
    .line 91
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 92
    .line 93
    .line 94
    move-result-object v0

    .line 95
    return-object v0
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
.end method
