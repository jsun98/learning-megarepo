t = [0:0.01:0.99];
y1 = sin(t*pi);
y2 = cos(t*pi);
plot(t,y1)
hold on;
plot(t,y2);
xlabel('time');
ylabel('value');
legend('sin','cos');
title('sin vs cos plot');
axis([0.5 1 -1 1]); % change x axis to 0.5 - 1 and y axis to -1 to 1
print -dpng 'myPlot.png';
% close; % closes the plot window
% clf; % clears the figure

