#include <stdio.h>
#include <string.h>

void reverse(char *str)
{
	char temp;
	char * end = str;
	if (str)
	{
		while(*end)
			end++;
	}
	end--;
	while(str < end)
	{
		temp = *str;
		*str++ = *end;
		*end-- = temp;
	}
}

int main(int argc, char const *argv[])
{
	char str[] = "kangze";
	//char *str = "kangze";  Bus error: 10
	reverse(str);
	printf("%s\n", str);
	printf("%c\n", str[6]);//index为6是存在的，‘／0’，但7就会越界
	return 0;
}