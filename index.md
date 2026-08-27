---
title: Software Analysis - Bryn Mawr College
layout: default
img: <!-- turk-engraving-detail -->
img_link: <!-- http://en.wikipedia.org/wiki/The_Turk -->
caption: <!--An engraving of the Mechanical Turk, the 18th century chess-playing automaton -->
active_tab: main_page 
---


This course offers an introduction to the theoretical foundations of software analysis and its applications in software engineering and security. Effective program analysis is essential for ensuring the reliability, security, and performance of software systems. Students will explore a range of methods for analyzing program behavior including testing, static analysis, and formal methods. The course emphasizes both theoretical knowledge and practical experience through implementation of analysis tools and engaging with current state-of-the-art techniques.

<!-- Display an alert about upcoming homework assignments -->
{% capture now %}{{'now' | date: '%s'}}{% endcapture %}
{% for page in site.pages %}
{% if page.release_date and page.due_date %}
{% capture release_date %}{{page.release_date | date: '%s'}}{% endcapture %}
{% capture due_date %}{{page.due_date | date: '%s'}}{% endcapture %}
{% if release_date < now and due_date >= now %}
<div class="alert alert-info">
<a href="{{site.url}}{{site.baseurl}}{{page.url}}">{{ page.title }}</a> has been released.  
{% if page.deliverables %}
The assignment has multiple deliverables.
{% for deliverable in page.deliverables %}
The {{deliverable.description}} is due before {{ deliverable.due_date | date: "%I:%M%p" }} on {{ deliverable.due_date | date: "%A, %B %-d, %Y" }}.  
{% endfor %}
{% else %}
It is due before {{ page.due_date | date: "%I:%M%p" }} on {{ page.due_date | date: "%A, %B %-d, %Y" }}.
{% endif %}
</div>
{% endif %}
{% endif %}
{% endfor %}
<!-- End alert for upcoming homework assignments -->


<!--
<div class="alert alert-info" markdown="1">
Check out the [excellent final projects](http://crowdsourcing-class.org/final-projects-2016.html) from last year's class.
</div>
-->


Course number
: CMSC B367 

Instructor
: [Elizabeth Dinella](https://elizabethdinella.github.io)

<!--
Teaching Assistants
: [Course Staff](staff.html) 
-->

Website 
: [https://bmc-cs-software-analysis.github.io/367](https://bmc-cs-software-analysis.github.io/367)

<!-- 
Code Samples From Lecture
: [Github](https://github.com/BMC-CS-151/class-examples-s24)
-->

Discussion Forum
: [Piazza](https://piazza.com/class/m61bd6hr6hw7h/)

Time and place
: Spring 2025, MW 10:10-11:30pm, Location: Park 337
: Lab M: 2:40-4:00pm, Location: Park 230


Course Readings
: Some lectures will have accompanying readings related to the lecture's topic

Grading
* Homeworks: 20%
* Labs: 35%
* Project: 40%
* Participation: 5%


<!--Late day policy
: As a general rule, no late homework will be accepted.
<br>
See the <a href="{{ site.url }}{{ site.baseurl }}/policies.html">Policies</a> for more details.-->

<!--#### Acknowledgments-->
