v = zeros(10,1);
for i = 1:10,
	v(i) = 2 ^ i;
end;
v

v = zeros(10,1);
i = 1;
while true
	v(i) = 999;
	i = i + 1;
	if i == 6,
		break;
	end;
end;
v

v = zeros(10,1);
v(1) = 2;
if v(1) == 1,
	disp('the value is one');
elseif v(1) == 2,
	disp('the value is two');
else,
	disp('the value is neither one nor two');
end;




