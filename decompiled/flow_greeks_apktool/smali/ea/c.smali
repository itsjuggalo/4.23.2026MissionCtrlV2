.class public Lea/c;
.super Lea/i;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lea/c$b;
    }
.end annotation


# instance fields
.field public final e:Lea/n;

.field public final f:Lea/n;

.field public final g:Lea/g;

.field public final h:Lea/a;

.field public final i:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lea/e;Lea/n;Lea/n;Lea/g;Lea/a;Ljava/lang/String;Ljava/util/Map;)V
    .locals 1

    .line 2
    sget-object v0, Lcom/google/firebase/inappmessaging/model/MessageType;->BANNER:Lcom/google/firebase/inappmessaging/model/MessageType;

    invoke-direct {p0, p1, v0, p7}, Lea/i;-><init>(Lea/e;Lcom/google/firebase/inappmessaging/model/MessageType;Ljava/util/Map;)V

    .line 3
    iput-object p2, p0, Lea/c;->e:Lea/n;

    .line 4
    iput-object p3, p0, Lea/c;->f:Lea/n;

    .line 5
    iput-object p4, p0, Lea/c;->g:Lea/g;

    .line 6
    iput-object p5, p0, Lea/c;->h:Lea/a;

    .line 7
    iput-object p6, p0, Lea/c;->i:Ljava/lang/String;

    return-void
.end method

.method public synthetic constructor <init>(Lea/e;Lea/n;Lea/n;Lea/g;Lea/a;Ljava/lang/String;Ljava/util/Map;Lea/c$a;)V
    .locals 0

    .line 1
    invoke-direct/range {p0 .. p7}, Lea/c;-><init>(Lea/e;Lea/n;Lea/n;Lea/g;Lea/a;Ljava/lang/String;Ljava/util/Map;)V

    return-void
.end method

.method public static d()Lea/c$b;
    .locals 1

    .line 1
    new-instance v0, Lea/c$b;

    .line 2
    .line 3
    invoke-direct {v0}, Lea/c$b;-><init>()V

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
.end method


# virtual methods
.method public b()Lea/g;
    .locals 1

    .line 1
    iget-object v0, p0, Lea/c;->g:Lea/g;

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

.method public e()Lea/a;
    .locals 1

    .line 1
    iget-object v0, p0, Lea/c;->h:Lea/a;

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

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .line 1
    const/4 v0, 0x1

    .line 2
    if-ne p1, p0, :cond_0

    .line 3
    .line 4
    return v0

    .line 5
    :cond_0
    instance-of v1, p1, Lea/c;

    .line 6
    .line 7
    const/4 v2, 0x0

    .line 8
    if-nez v1, :cond_1

    .line 9
    .line 10
    return v2

    .line 11
    :cond_1
    check-cast p1, Lea/c;

    .line 12
    .line 13
    invoke-virtual {p0}, Lea/c;->hashCode()I

    .line 14
    .line 15
    .line 16
    move-result v1

    .line 17
    invoke-virtual {p1}, Lea/c;->hashCode()I

    .line 18
    .line 19
    .line 20
    move-result v3

    .line 21
    if-eq v1, v3, :cond_2

    .line 22
    .line 23
    return v2

    .line 24
    :cond_2
    iget-object v1, p0, Lea/c;->f:Lea/n;

    .line 25
    .line 26
    if-nez v1, :cond_3

    .line 27
    .line 28
    iget-object v3, p1, Lea/c;->f:Lea/n;

    .line 29
    .line 30
    if-nez v3, :cond_4

    .line 31
    .line 32
    :cond_3
    if-eqz v1, :cond_5

    .line 33
    .line 34
    iget-object v3, p1, Lea/c;->f:Lea/n;

    .line 35
    .line 36
    invoke-virtual {v1, v3}, Lea/n;->equals(Ljava/lang/Object;)Z

    .line 37
    .line 38
    .line 39
    move-result v1

    .line 40
    if-nez v1, :cond_5

    .line 41
    .line 42
    :cond_4
    return v2

    .line 43
    :cond_5
    iget-object v1, p0, Lea/c;->g:Lea/g;

    .line 44
    .line 45
    if-nez v1, :cond_6

    .line 46
    .line 47
    iget-object v3, p1, Lea/c;->g:Lea/g;

    .line 48
    .line 49
    if-nez v3, :cond_7

    .line 50
    .line 51
    :cond_6
    if-eqz v1, :cond_8

    .line 52
    .line 53
    iget-object v3, p1, Lea/c;->g:Lea/g;

    .line 54
    .line 55
    invoke-virtual {v1, v3}, Lea/g;->equals(Ljava/lang/Object;)Z

    .line 56
    .line 57
    .line 58
    move-result v1

    .line 59
    if-nez v1, :cond_8

    .line 60
    .line 61
    :cond_7
    return v2

    .line 62
    :cond_8
    iget-object v1, p0, Lea/c;->h:Lea/a;

    .line 63
    .line 64
    if-nez v1, :cond_9

    .line 65
    .line 66
    iget-object v3, p1, Lea/c;->h:Lea/a;

    .line 67
    .line 68
    if-nez v3, :cond_a

    .line 69
    .line 70
    :cond_9
    if-eqz v1, :cond_b

    .line 71
    .line 72
    iget-object v3, p1, Lea/c;->h:Lea/a;

    .line 73
    .line 74
    invoke-virtual {v1, v3}, Lea/a;->equals(Ljava/lang/Object;)Z

    .line 75
    .line 76
    .line 77
    move-result v1

    .line 78
    if-nez v1, :cond_b

    .line 79
    .line 80
    :cond_a
    return v2

    .line 81
    :cond_b
    iget-object v1, p0, Lea/c;->e:Lea/n;

    .line 82
    .line 83
    iget-object v3, p1, Lea/c;->e:Lea/n;

    .line 84
    .line 85
    invoke-virtual {v1, v3}, Lea/n;->equals(Ljava/lang/Object;)Z

    .line 86
    .line 87
    .line 88
    move-result v1

    .line 89
    if-nez v1, :cond_c

    .line 90
    .line 91
    return v2

    .line 92
    :cond_c
    iget-object v1, p0, Lea/c;->i:Ljava/lang/String;

    .line 93
    .line 94
    iget-object p1, p1, Lea/c;->i:Ljava/lang/String;

    .line 95
    .line 96
    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 97
    .line 98
    .line 99
    move-result p1

    .line 100
    if-eqz p1, :cond_d

    .line 101
    .line 102
    return v0

    .line 103
    :cond_d
    return v2
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

.method public f()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lea/c;->i:Ljava/lang/String;

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

.method public g()Lea/n;
    .locals 1

    .line 1
    iget-object v0, p0, Lea/c;->f:Lea/n;

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

.method public h()Lea/n;
    .locals 1

    .line 1
    iget-object v0, p0, Lea/c;->e:Lea/n;

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

.method public hashCode()I
    .locals 4

    .line 1
    iget-object v0, p0, Lea/c;->f:Lea/n;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-eqz v0, :cond_0

    .line 5
    .line 6
    invoke-virtual {v0}, Lea/n;->hashCode()I

    .line 7
    .line 8
    .line 9
    move-result v0

    .line 10
    goto :goto_0

    .line 11
    :cond_0
    move v0, v1

    .line 12
    :goto_0
    iget-object v2, p0, Lea/c;->g:Lea/g;

    .line 13
    .line 14
    if-eqz v2, :cond_1

    .line 15
    .line 16
    invoke-virtual {v2}, Lea/g;->hashCode()I

    .line 17
    .line 18
    .line 19
    move-result v2

    .line 20
    goto :goto_1

    .line 21
    :cond_1
    move v2, v1

    .line 22
    :goto_1
    iget-object v3, p0, Lea/c;->h:Lea/a;

    .line 23
    .line 24
    if-eqz v3, :cond_2

    .line 25
    .line 26
    invoke-virtual {v3}, Lea/a;->hashCode()I

    .line 27
    .line 28
    .line 29
    move-result v1

    .line 30
    :cond_2
    iget-object v3, p0, Lea/c;->e:Lea/n;

    .line 31
    .line 32
    invoke-virtual {v3}, Lea/n;->hashCode()I

    .line 33
    .line 34
    .line 35
    move-result v3

    .line 36
    add-int/2addr v3, v0

    .line 37
    add-int/2addr v3, v2

    .line 38
    add-int/2addr v3, v1

    .line 39
    iget-object v0, p0, Lea/c;->i:Ljava/lang/String;

    .line 40
    .line 41
    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    .line 42
    .line 43
    .line 44
    move-result v0

    .line 45
    add-int/2addr v3, v0

    .line 46
    return v3
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
