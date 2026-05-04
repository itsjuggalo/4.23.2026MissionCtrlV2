.class public final Lma/a$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lma/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public a:J

.field public b:Ljava/lang/String;

.field public c:Ljava/lang/String;

.field public d:Lma/a$c;

.field public e:Lma/a$d;

.field public f:Ljava/lang/String;

.field public g:Ljava/lang/String;

.field public h:I

.field public i:I

.field public j:Ljava/lang/String;

.field public k:J

.field public l:Lma/a$b;

.field public m:Ljava/lang/String;

.field public n:J

.field public o:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 4

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    const-wide/16 v0, 0x0

    .line 5
    .line 6
    iput-wide v0, p0, Lma/a$a;->a:J

    .line 7
    .line 8
    const-string v2, ""

    .line 9
    .line 10
    iput-object v2, p0, Lma/a$a;->b:Ljava/lang/String;

    .line 11
    .line 12
    iput-object v2, p0, Lma/a$a;->c:Ljava/lang/String;

    .line 13
    .line 14
    sget-object v3, Lma/a$c;->b:Lma/a$c;

    .line 15
    .line 16
    iput-object v3, p0, Lma/a$a;->d:Lma/a$c;

    .line 17
    .line 18
    sget-object v3, Lma/a$d;->b:Lma/a$d;

    .line 19
    .line 20
    iput-object v3, p0, Lma/a$a;->e:Lma/a$d;

    .line 21
    .line 22
    iput-object v2, p0, Lma/a$a;->f:Ljava/lang/String;

    .line 23
    .line 24
    iput-object v2, p0, Lma/a$a;->g:Ljava/lang/String;

    .line 25
    .line 26
    const/4 v3, 0x0

    .line 27
    iput v3, p0, Lma/a$a;->h:I

    .line 28
    .line 29
    iput v3, p0, Lma/a$a;->i:I

    .line 30
    .line 31
    iput-object v2, p0, Lma/a$a;->j:Ljava/lang/String;

    .line 32
    .line 33
    iput-wide v0, p0, Lma/a$a;->k:J

    .line 34
    .line 35
    sget-object v3, Lma/a$b;->b:Lma/a$b;

    .line 36
    .line 37
    iput-object v3, p0, Lma/a$a;->l:Lma/a$b;

    .line 38
    .line 39
    iput-object v2, p0, Lma/a$a;->m:Ljava/lang/String;

    .line 40
    .line 41
    iput-wide v0, p0, Lma/a$a;->n:J

    .line 42
    .line 43
    iput-object v2, p0, Lma/a$a;->o:Ljava/lang/String;

    .line 44
    .line 45
    return-void
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


# virtual methods
.method public a()Lma/a;
    .locals 23

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    new-instance v1, Lma/a;

    .line 4
    .line 5
    iget-wide v2, v0, Lma/a$a;->a:J

    .line 6
    .line 7
    iget-object v4, v0, Lma/a$a;->b:Ljava/lang/String;

    .line 8
    .line 9
    iget-object v5, v0, Lma/a$a;->c:Ljava/lang/String;

    .line 10
    .line 11
    iget-object v6, v0, Lma/a$a;->d:Lma/a$c;

    .line 12
    .line 13
    iget-object v7, v0, Lma/a$a;->e:Lma/a$d;

    .line 14
    .line 15
    iget-object v8, v0, Lma/a$a;->f:Ljava/lang/String;

    .line 16
    .line 17
    iget-object v9, v0, Lma/a$a;->g:Ljava/lang/String;

    .line 18
    .line 19
    iget v10, v0, Lma/a$a;->h:I

    .line 20
    .line 21
    iget v11, v0, Lma/a$a;->i:I

    .line 22
    .line 23
    iget-object v12, v0, Lma/a$a;->j:Ljava/lang/String;

    .line 24
    .line 25
    iget-wide v13, v0, Lma/a$a;->k:J

    .line 26
    .line 27
    iget-object v15, v0, Lma/a$a;->l:Lma/a$b;

    .line 28
    .line 29
    move-object/from16 v16, v1

    .line 30
    .line 31
    iget-object v1, v0, Lma/a$a;->m:Ljava/lang/String;

    .line 32
    .line 33
    move-wide/from16 v17, v2

    .line 34
    .line 35
    move-object v3, v1

    .line 36
    iget-wide v1, v0, Lma/a$a;->n:J

    .line 37
    .line 38
    move-wide/from16 v19, v1

    .line 39
    .line 40
    iget-object v1, v0, Lma/a$a;->o:Ljava/lang/String;

    .line 41
    .line 42
    move-wide/from16 v21, v19

    .line 43
    .line 44
    move-object/from16 v19, v1

    .line 45
    .line 46
    move-object/from16 v1, v16

    .line 47
    .line 48
    move-object/from16 v16, v3

    .line 49
    .line 50
    move-wide/from16 v2, v17

    .line 51
    .line 52
    move-wide/from16 v17, v21

    .line 53
    .line 54
    invoke-direct/range {v1 .. v19}, Lma/a;-><init>(JLjava/lang/String;Ljava/lang/String;Lma/a$c;Lma/a$d;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;JLma/a$b;Ljava/lang/String;JLjava/lang/String;)V

    .line 55
    .line 56
    .line 57
    move-object/from16 v16, v1

    .line 58
    .line 59
    return-object v16
    .line 60
    .line 61
.end method

.method public b(Ljava/lang/String;)Lma/a$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lma/a$a;->m:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public c(Ljava/lang/String;)Lma/a$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lma/a$a;->g:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public d(Ljava/lang/String;)Lma/a$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lma/a$a;->o:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public e(Lma/a$b;)Lma/a$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lma/a$a;->l:Lma/a$b;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public f(Ljava/lang/String;)Lma/a$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lma/a$a;->c:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public g(Ljava/lang/String;)Lma/a$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lma/a$a;->b:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public h(Lma/a$c;)Lma/a$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lma/a$a;->d:Lma/a$c;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public i(Ljava/lang/String;)Lma/a$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lma/a$a;->f:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public j(I)Lma/a$a;
    .locals 0

    .line 1
    iput p1, p0, Lma/a$a;->h:I

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public k(J)Lma/a$a;
    .locals 0

    .line 1
    iput-wide p1, p0, Lma/a$a;->a:J

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public l(Lma/a$d;)Lma/a$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lma/a$a;->e:Lma/a$d;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public m(Ljava/lang/String;)Lma/a$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lma/a$a;->j:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public n(I)Lma/a$a;
    .locals 0

    .line 1
    iput p1, p0, Lma/a$a;->i:I

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method
