/*
 *  doubly circular linked list
 *
 *  Data Structures
 *
 *  Department of Computer Science
 *  at Chungbuk National University
 *
 */



#include<stdio.h>
#include<stdlib.h>
 /* 필요한 헤더파일 추가 */

typedef struct Node {
	int key;
	struct Node* llink;
	struct Node* rlink;
} listNode;

/* 함수 리스트 */
int initialize(listNode** h);
int freeList(listNode* h);
int insertLast(listNode* h, int key);
int deleteLast(listNode* h);
int insertFirst(listNode* h, int key);
int deleteFirst(listNode* h);
int invertList(listNode* h);

int insertNode(listNode* h, int key);
int deleteNode(listNode* h, int key);

void printList(listNode* h);



int main()
{
	char command;
	int key;
	listNode* headnode = NULL;

	do {
		printf("[----- [고승현] [2016039086] -----]\n");
		printf("----------------------------------------------------------------\n");
		printf("                  Doubly Circular Linked List                   \n");
		printf("----------------------------------------------------------------\n");
		printf(" Initialize    = z           Print         = p \n");
		printf(" Insert Node   = i           Delete Node   = d \n");
		printf(" Insert Last   = n           Delete Last   = e\n");
		printf(" Insert First  = f           Delete First  = t\n");
		printf(" Invert List   = r           Quit          = q\n");
		printf("----------------------------------------------------------------\n");

		printf("Command = ");
		scanf(" %c", &command);

		switch (command) {
		case 'z': case 'Z':
			initialize(&headnode);
			break;
		case 'p': case 'P':
			printList(headnode);
			break;
		case 'i': case 'I':
			printf("Your Key = ");
			scanf("%d", &key);
			insertNode(headnode, key);
			break;
		case 'd': case 'D':
			printf("Your Key = ");
			scanf("%d", &key);
			deleteNode(headnode, key);
			break;
		case 'n': case 'N':
			printf("Your Key = ");
			scanf("%d", &key);
			insertLast(headnode, key);
			break;
		case 'e': case 'E':
			deleteLast(headnode);
			break;
		case 'f': case 'F':
			printf("Your Key = ");
			scanf("%d", &key);
			insertFirst(headnode, key);
			break;
		case 't': case 'T':
			deleteFirst(headnode);
			break;
		case 'r': case 'R':
			invertList(headnode);
			break;
		case 'q': case 'Q':
			freeList(headnode);
			break;
		default:
			printf("\n       >>>>>   Concentration!!   <<<<<     \n");
			break;
		}

	} while (command != 'q' && command != 'Q');

	return 1;
}


int initialize(listNode** h) {

	/* headNode가 NULL이 아니면, freeNode를 호출하여 할당된 메모리 모두 해제
	이중포인터로 매개변수를 받았으므로 해당 함수에서 메인함수의 포인터의 값을 수정해서
	적용하여 리턴해준다 */
	if (*h != NULL)
		freeList(*h);

	/* headNode에 대한 메모리를 할당하여 리턴 */
	*h = (listNode*)malloc(sizeof(listNode));
	(*h)->rlink = *h;
	(*h)->llink = *h;
	(*h)->key = -9999;
	return 1;
}

/* 메모리 해제 
preview를 통해서 차례로 메모리를 해제하고 전부 해제후
마지막에는 h의 구조체에 해당하는 메모리를 해제해준다*/
int freeList(listNode* h) {
	listNode* p;
	listNode* preview=h;
	p = h->rlink;
	if (h == NULL)
		return 0;
	else if (p == h) {
		free(p);
		return 0;
	}
	else {
		while (p != h) {
			preview = p;
			p = p->rlink;
			free(preview);
			if (p == h) {
				free(p);
			}
		}

	}
	return 0;
}



void printList(listNode* h) {
	int i = 0;
	listNode* p;

	printf("\n---PRINT\n");

	if (h == NULL) {
		printf("Nothing to print....\n");
		return;
	}

	p = h->rlink;

	while (p != NULL && p != h) {
		printf("[ [%d]=%d ] ", i, p->key);
		p = p->rlink;
		i++;
	}
	printf("  items = %d\n", i);


	/* print addresses */
	printf("\n---checking addresses of links\n");
	printf("-------------------------------\n");
	printf("head node: [llink]=%p, [head]=%p, [rlink]=%p\n", h->llink, h, h->rlink);

	i = 0;
	p = h->rlink;
	while (p != NULL && p != h) {
		printf("[ [%d]=%d ] [llink]=%p, [node]=%p, [rlink]=%p\n", i, p->key, p->llink, p, p->rlink);
		p = p->rlink;
		i++;
	}

}



/**
 * list에 key에 대한 노드하나를 추가
 * 포인터 변수p를통해서 알맞는 값의 위치를 찾고 연결해준다
 * 아무런 노드가 없는 경우 처음위치에 넣는것과 동일해서 insertFirst()이용
 */
int insertLast(listNode* h, int key) {
	listNode* p;
	listNode* temp;
	p = h->rlink;
	if (h == NULL)
		return 1;
	if (p == h) {
		insertFirst(h, key);
		return 1;
	}
	temp = (listNode*)malloc(sizeof(listNode));
	temp->key = key;
	temp->rlink = temp;
	temp->llink = temp;
	temp->llink = h->llink;
	temp->rlink = h;
	h->llink->rlink = temp;
	h->llink = temp;
	return 1;
}


/**
 * list의 마지막 노드 삭제
 * 만약에 아무런 노드가 없는경우 즉 초기화만 시켜준경우 h를 free
 * 그외의 경우는 노드가 있으므로 마지막 노드를 free 
 */
int deleteLast(listNode* h) {
	listNode* p;
	p = h->llink;
	if (h == NULL)
		return 1;
	if (h->rlink == h->llink) {
		free(h);
		return 1;
	}
	else {
		p->llink->rlink = h;
		h->llink = p->llink;
		free(p);
	}


	return 1;
}


/**
 * list 처음에 key에 대한 노드하나를 추가
 * 초기화를 시켜준후 첫번째 위치에 노드를 추가
 */
int insertFirst(listNode* h, int key) {
	listNode* p;
	listNode* temp;
	p = h->rlink;
	if (h == NULL)
		return 1;
	temp = (listNode*)malloc(sizeof(listNode));
	temp->key = key;
	temp->llink = temp;
	temp->rlink = temp;
	if (p == h) {
		p->rlink = temp;
		temp->llink = p;
		p->llink = temp;
		temp->rlink = p;
	}
	else {
		temp->rlink = p;
		p->llink = temp;
		temp->llink = h;
		h->rlink = temp;
	}
	return 1;
}

/**
 * list의 첫번째 노드 삭제
 * 노드가 없는 경우 초기화시 생성한 노드를 해제
 * 그외의 경우는 노드가 있으므로 해제
 */
int deleteFirst(listNode* h) {
	listNode* p;
	p = h->rlink;
	if (h == NULL)
		return 1;
	if (h->llink == h->rlink) {
		free(h);

	}
	else if (h->llink == p) {
		h->rlink = h;
		free(p);
	}
	else {
		h->rlink = p->rlink;
		p->rlink->llink = h;
		free(p);
	}

	return 1;

}


/**
 * 리스트의 링크를 역순으로 재 배치
 * llink와rlink의 위치를 바꿔서 역순으로 배치
 * head노드의 링크로 마지막에 바꾼다
 */
int invertList(listNode* h) {
	listNode* p;
	listNode* temp;
	p = h->rlink;
	while (p != h) {
		temp = p->llink;
		p->llink = p->rlink;
		p->rlink = temp;
		p = p->llink;
	}
	temp = p->llink;
	p->llink = p->rlink;
	p->rlink = temp;

	return 0;
}



/**
 *  리스트를 검색하여, 입력받은 key보다 큰값이 나오는 노드 바로 앞에 삽입
 * 크기를 비교해서 알맞은 위치에 노드를 삽입
 * 만약에 가장큰경우 마지막 값까지 비교후 노드를 마지막에 삽입
 **/
int insertNode(listNode* h, int key) {
	listNode* p;
	listNode* temp;
	p = h->rlink;
	if (h == NULL)
		return 0;
	if (p==h) {
		insertFirst(h, key);
		return 0;
	}
	else {
		while (p != h) {
			if (key <= p->key) {
				temp = (listNode*)malloc(sizeof(listNode));
				temp->key = key;
				temp->rlink = p;
				temp->llink = p->llink;
 				temp->llink->rlink = temp;
				temp->rlink->llink = temp;
				return 0;
			}
			p = p->rlink;
			if (p == h) {
				insertLast(h, key);
				return 0;
			}
		}
	}
	
	return 0;
}


/**
 * list에서 key에 대한 노드 삭제
 * 반복문을 돌면서 키값과 알맞은 노드를 삭제
 */
int deleteNode(listNode* h, int key) {
	listNode* p;
	p = h->rlink;
	if (h == NULL)
		return 0;
	while (p != h) {
		if (p->key == key) {
			if (p->rlink == h) {
				p->llink->rlink = h;
				h->llink = p->llink;
				free(p);
			}
			else {
				p->llink->rlink = p->rlink;
				p->rlink->llink = p->llink;
				free(p);
			}
			break;
		}
		p = p->rlink;
	}
	return 0;
}




