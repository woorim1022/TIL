# Git

> 인용문 사용할 때, 강조할 때 등 (>)
>
> 깃은 '분산 버전 관리 시스템'(DVCS)이다.

## 로컬 저장소 설정 

```bash
$ git init 
(master) $ 
```



* .git 숨김 폴더가 생성된다.
* (master) 브랜치 표기된다.
* 

## 기본 흐름

* 어떠한 작업 => $ touch 파일명

```bash
$ git status
On branch master

No commits yet
# 트래킹이 X 파일들
# 버전에 기록된 적 없는 파일들 
# => 파일 생성 등

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        1.txt
        Git.md
        "Markdown \353\254\270\353\262\225 \354\240\225\353\246\254.md"
# 커밋을 할 파일이 없다.(SA X)
# but, untracked files은 있다.(WD 0)

nothing added to commit but untracked files present (use "git add" to track)

```

### add

```bash
$ git add .
$ git add a.txt
$ git add test/ # 특정 폴더

$ git status
On branch master

No commits yet
# 커밋이 될 변경사항들(SA 0) 
Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   1.txt
        new file:   Git.md
        new file:   "Markdown \353\254\270\353\262\225 \354\240\225\353\246\254.md"


```

### commit

스냅샷, 버전을 새롭게

```bash
$ git commit -m '커밋메시지'g
[master (root-commit) 2fb43e8] 커밋메시지
 3 files changed, 99 insertions(+)
 create mode 100644 1.txt
 create mode 100644 Git.md
 create mode 100644 "Markdown \353\254\270\353\262\225 \354\240\225\353\246\254.md"

```

* 해시값이 고유한 커밋을 의미	

  예) 2fb43e8725890061da8255ffc46636fcbb9f3948

* 커밋 메시지는 반드시 현재 작업 내용을 나타낼 수 있도록 잘 작성하는것이 중요

## 기타 상태 명령어

### 상태 확인

```bash
$ git status
```

### 커밋 히스토리(log)

```bash
$ git log
commit 2fb43e8725890061da8255ffc46636fcbb9f3948 (HEAD -> master)
Author: woorim1022 <woorim1022@naver.com>
Date:   Thu Jan 7 14:18:38 2021 +0900

    커밋메시지
```





