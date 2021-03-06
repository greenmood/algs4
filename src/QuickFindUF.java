<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang = "en">

<head>

<link rel="icon"          href="http://algs4.cs.princeton.edu/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="http://algs4.cs.princeton.edu/favicon.ico" type="image/x-icon">
<link rel="stylesheet"    href="http://algs4.cs.princeton.edu/java.css" type="text/css">

<title>QuickFindUF.java</title>

<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=iso-8859-1">
<meta NAME="AUTHOR" CONTENT="Robert Sedgewick and Kevin Wayne">
<meta NAME="DESCRIPTION" CONTENT="QuickFindUF code in Java">
<meta NAME="TITLE" CONTENT="QuickFindUF code in Java">
<meta NAME="KEYWORDS" CONTENT="QuickFindUF,java,programming,computer science,algorithm,data structure,program,code">
<meta NAME="ROBOTS" CONTENT="INDEX,FOLLOW">

</head>


<body>
<center><h1>QuickFindUF.java</h1></center><p><br>

Below is the syntax highlighted version of <a href = "QuickFindUF.java">QuickFindUF.java</a>
from <a href = "http://algs4.cs.princeton.edu/15uf">&#167;1.5 Case Study: Union-Find</a>.
&nbsp; Here is the <a href = "http://algs4.cs.princeton.edu/code/javadoc/QuickFindUF.html">Javadoc</a>.
<p><br>

<!-- Generator: GNU source-highlight 3.1.6
by Lorenzo Bettini
http://www.lorenzobettini.it
http://www.gnu.org/software/src-highlite -->
<pre><tt><span class="comment">/****************************************************************************</span>
<span class="comment"> *  Compilation:  javac QuickFindUF.java</span>
<span class="comment"> *  Execution:  java QuickFindUF &lt; input.txt</span>
<span class="comment"> *  Dependencies: StdIn.java StdOut.java</span>
<span class="comment"> *</span>
<span class="comment"> *  Quick-find algorithm.</span>
<span class="comment"> *</span>
<span class="comment"> ****************************************************************************/</span>

<span class="comment">/**</span>
<span class="comment"> *  The </span><span class="keyword">&lt;tt&gt;</span><span class="comment">QuickFindUF</span><span class="keyword">&lt;/tt&gt;</span><span class="comment"> class represents a union-find data structure.</span>
<span class="comment"> *  It supports the </span><span class="keyword">&lt;em&gt;</span><span class="comment">union</span><span class="keyword">&lt;/em&gt;</span><span class="comment"> and </span><span class="keyword">&lt;em&gt;</span><span class="comment">find</span><span class="keyword">&lt;/em&gt;</span><span class="comment"> operations, along with</span>
<span class="comment"> *  methods for determinig whether two objects are in the same component</span>
<span class="comment"> *  and the total number of components.</span>
<span class="comment"> *  </span><span class="keyword">&lt;p&gt;</span>
<span class="comment"> *  This implementation uses quick find.</span>
<span class="comment"> *  Initializing a data structure with </span><span class="keyword">&lt;em&gt;</span><span class="comment">N</span><span class="keyword">&lt;/em&gt;</span><span class="comment"> objects takes linear time.</span>
<span class="comment"> *  Afterwards, </span><span class="keyword">&lt;em&gt;</span><span class="comment">find</span><span class="keyword">&lt;/em&gt;</span><span class="comment">, </span><span class="keyword">&lt;em&gt;</span><span class="comment">connected</span><span class="keyword">&lt;/em&gt;</span><span class="comment">, and </span><span class="keyword">&lt;em&gt;</span><span class="comment">count</span><span class="keyword">&lt;/em&gt;</span>
<span class="comment"> *  takes constant time but </span><span class="keyword">&lt;em&gt;</span><span class="comment">union</span><span class="keyword">&lt;/em&gt;</span><span class="comment"> takes linear time.</span>
<span class="comment"> *  </span><span class="keyword">&lt;p&gt;</span>
<span class="comment"> *  For additional documentation, see </span><span class="keyword">&lt;a</span><span class="normal"> </span><span class="type">href</span><span class="symbol">=</span><span class="string">"http://algs4.cs.princeton.edu/15uf"</span><span class="keyword">&gt;</span><span class="comment">Section 1.5</span><span class="keyword">&lt;/a&gt;</span><span class="comment"> of</span>
<span class="comment"> *  </span><span class="keyword">&lt;i&gt;</span><span class="comment">Algorithms, 4th Edition</span><span class="keyword">&lt;/i&gt;</span><span class="comment"> by Robert Sedgewick and Kevin Wayne.</span>
<span class="comment"> *     </span>
<span class="comment"> *  </span><span class="type">@author</span><span class="comment"> Robert Sedgewick</span>
<span class="comment"> *  </span><span class="type">@author</span><span class="comment"> Kevin Wayne</span>
<span class="comment"> */</span>
<span class="keyword">public</span><span class="normal"> </span><span class="keyword">class</span><span class="normal"> </span><span class="classname">QuickFindUF</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">    </span><span class="keyword">private</span><span class="normal"> </span><span class="type">int</span><span class="symbol">[]</span><span class="normal"> id</span><span class="symbol">;</span><span class="normal">    </span><span class="comment">// id[i] = component identifier of i</span>
<span class="normal">    </span><span class="keyword">private</span><span class="normal"> </span><span class="type">int</span><span class="normal"> count</span><span class="symbol">;</span><span class="normal">   </span><span class="comment">// number of components</span>

<span class="normal">    </span><span class="comment">/**</span>
<span class="comment">     * Initializes an empty union-find data structure with N isolated components 0 through N-1.</span>
<span class="comment">     * </span><span class="type">@throws</span><span class="comment"> java.lang.IllegalArgumentException if N &lt; 0</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment"> N the number of objects</span>
<span class="comment">     */</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="function">QuickFindUF</span><span class="symbol">(</span><span class="type">int</span><span class="normal"> N</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        count </span><span class="symbol">=</span><span class="normal"> N</span><span class="symbol">;</span>
<span class="normal">        id </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="type">int</span><span class="symbol">[</span><span class="normal">N</span><span class="symbol">];</span>
<span class="normal">        </span><span class="keyword">for</span><span class="normal"> </span><span class="symbol">(</span><span class="type">int</span><span class="normal"> i </span><span class="symbol">=</span><span class="normal"> </span><span class="number">0</span><span class="symbol">;</span><span class="normal"> i </span><span class="symbol">&lt;</span><span class="normal"> N</span><span class="symbol">;</span><span class="normal"> i</span><span class="symbol">++)</span>
<span class="normal">            id</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">]</span><span class="normal"> </span><span class="symbol">=</span><span class="normal"> i</span><span class="symbol">;</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">/**</span>
<span class="comment">     * Returns the number of components.</span>
<span class="comment">     * </span><span class="type">@return</span><span class="comment"> the number of components (between 1 and N)</span>
<span class="comment">     */</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="type">int</span><span class="normal"> </span><span class="function">count</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> count</span><span class="symbol">;</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">/**</span>
<span class="comment">     * Returns the component identifier for the component containing site </span><span class="keyword">&lt;tt&gt;</span><span class="comment">p</span><span class="keyword">&lt;/tt&gt;</span><span class="comment">.</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment"> p the integer representing one site</span>
<span class="comment">     * </span><span class="type">@return</span><span class="comment"> the component identifier for the component containing site </span><span class="keyword">&lt;tt&gt;</span><span class="comment">p</span><span class="keyword">&lt;/tt&gt;</span>
<span class="comment">     * </span><span class="type">@throws</span><span class="comment"> java.lang.IndexOutOfBoundsException unless 0 &lt;= p &lt; N</span>
<span class="comment">     */</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="type">int</span><span class="normal"> </span><span class="function">find</span><span class="symbol">(</span><span class="type">int</span><span class="normal"> p</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> id</span><span class="symbol">[</span><span class="normal">p</span><span class="symbol">];</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">/**</span>
<span class="comment">     * Are the two sites </span><span class="keyword">&lt;tt&gt;</span><span class="comment">p</span><span class="keyword">&lt;/tt&gt;</span><span class="comment"> and </span><span class="keyword">&lt;tt&gt;</span><span class="comment">q/tt&gt; in the same component?</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment"> p the integer representing one site</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment"> q the integer representing the other site</span>
<span class="comment">     * </span><span class="type">@return</span><span class="comment"> </span><span class="keyword">&lt;tt&gt;</span><span class="comment">true</span><span class="keyword">&lt;/tt&gt;</span><span class="comment"> if the two sites </span><span class="keyword">&lt;tt&gt;</span><span class="comment">p</span><span class="keyword">&lt;/tt&gt;</span><span class="comment"> and </span><span class="keyword">&lt;tt&gt;</span><span class="comment">q</span><span class="keyword">&lt;/tt&gt;</span><span class="comment"> are in</span>
<span class="comment">     *    the same component, and </span><span class="keyword">&lt;tt&gt;</span><span class="comment">false</span><span class="keyword">&lt;/tt&gt;</span><span class="comment"> otherwise</span>
<span class="comment">     * </span><span class="type">@throws</span><span class="comment"> java.lang.IndexOutOfBoundsException unless both 0 &lt;= p &lt; N and 0 &lt;= q &lt; N</span>
<span class="comment">     */</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="type">boolean</span><span class="normal"> </span><span class="function">connected</span><span class="symbol">(</span><span class="type">int</span><span class="normal"> p</span><span class="symbol">,</span><span class="normal"> </span><span class="type">int</span><span class="normal"> q</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> id</span><span class="symbol">[</span><span class="normal">p</span><span class="symbol">]</span><span class="normal"> </span><span class="symbol">==</span><span class="normal"> id</span><span class="symbol">[</span><span class="normal">q</span><span class="symbol">];</span>
<span class="normal">    </span><span class="cbracket">}</span>
<span class="normal">  </span>
<span class="normal">    </span><span class="comment">/**</span>
<span class="comment">     * Merges the component containing site</span><span class="keyword">&lt;tt&gt;</span><span class="comment">p</span><span class="keyword">&lt;/tt&gt;</span><span class="comment"> with the component</span>
<span class="comment">     * containing site </span><span class="keyword">&lt;tt&gt;</span><span class="comment">q</span><span class="keyword">&lt;/tt&gt;</span><span class="comment">.</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment"> p the integer representing one site</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment"> q the integer representing the other site</span>
<span class="comment">     * </span><span class="type">@throws</span><span class="comment"> java.lang.IndexOutOfBoundsException unless both 0 &lt;= p &lt; N and 0 &lt;= q &lt; N</span>
<span class="comment">     */</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="type">void</span><span class="normal"> </span><span class="function">union</span><span class="symbol">(</span><span class="type">int</span><span class="normal"> p</span><span class="symbol">,</span><span class="normal"> </span><span class="type">int</span><span class="normal"> q</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="function">connected</span><span class="symbol">(</span><span class="normal">p</span><span class="symbol">,</span><span class="normal"> q</span><span class="symbol">))</span><span class="normal"> </span><span class="keyword">return</span><span class="symbol">;</span>
<span class="normal">        </span><span class="type">int</span><span class="normal"> pid </span><span class="symbol">=</span><span class="normal"> id</span><span class="symbol">[</span><span class="normal">p</span><span class="symbol">];</span>
<span class="normal">        </span><span class="keyword">for</span><span class="normal"> </span><span class="symbol">(</span><span class="type">int</span><span class="normal"> i </span><span class="symbol">=</span><span class="normal"> </span><span class="number">0</span><span class="symbol">;</span><span class="normal"> i </span><span class="symbol">&lt;</span><span class="normal"> id</span><span class="symbol">.</span><span class="normal">length</span><span class="symbol">;</span><span class="normal"> i</span><span class="symbol">++)</span>
<span class="normal">            </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">id</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">]</span><span class="normal"> </span><span class="symbol">==</span><span class="normal"> pid</span><span class="symbol">)</span><span class="normal"> id</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">]</span><span class="normal"> </span><span class="symbol">=</span><span class="normal"> id</span><span class="symbol">[</span><span class="normal">q</span><span class="symbol">];</span><span class="normal"> </span>
<span class="normal">        count</span><span class="symbol">--;</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">/**</span>
<span class="comment">     * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input, </span>
<span class="comment">     * where each integer represents some object;</span>
<span class="comment">     * if the objects are in different components, merge the two components</span>
<span class="comment">     * and print the pair to standard output.</span>
<span class="comment">     */</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="keyword">static</span><span class="normal"> </span><span class="type">void</span><span class="normal"> </span><span class="function">main</span><span class="symbol">(</span><span class="normal">String</span><span class="symbol">[]</span><span class="normal"> args</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="type">int</span><span class="normal"> N </span><span class="symbol">=</span><span class="normal"> StdIn</span><span class="symbol">.</span><span class="function">readInt</span><span class="symbol">();</span>
<span class="normal">        </span><span class="usertype">QuickFindUF</span><span class="normal"> uf </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">QuickFindUF</span><span class="symbol">(</span><span class="normal">N</span><span class="symbol">);</span>
<span class="normal">        </span><span class="keyword">while</span><span class="normal"> </span><span class="symbol">(!</span><span class="normal">StdIn</span><span class="symbol">.</span><span class="function">isEmpty</span><span class="symbol">())</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">            </span><span class="type">int</span><span class="normal"> p </span><span class="symbol">=</span><span class="normal"> StdIn</span><span class="symbol">.</span><span class="function">readInt</span><span class="symbol">();</span>
<span class="normal">            </span><span class="type">int</span><span class="normal"> q </span><span class="symbol">=</span><span class="normal"> StdIn</span><span class="symbol">.</span><span class="function">readInt</span><span class="symbol">();</span>
<span class="normal">            </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">uf</span><span class="symbol">.</span><span class="function">connected</span><span class="symbol">(</span><span class="normal">p</span><span class="symbol">,</span><span class="normal"> q</span><span class="symbol">))</span><span class="normal"> </span><span class="keyword">continue</span><span class="symbol">;</span>
<span class="normal">            uf</span><span class="symbol">.</span><span class="function">union</span><span class="symbol">(</span><span class="normal">p</span><span class="symbol">,</span><span class="normal"> q</span><span class="symbol">);</span>
<span class="normal">            StdOut</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="normal">p </span><span class="symbol">+</span><span class="normal"> </span><span class="string">" "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> q</span><span class="symbol">);</span>
<span class="normal">        </span><span class="cbracket">}</span>
<span class="normal">        StdOut</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="normal">uf</span><span class="symbol">.</span><span class="function">count</span><span class="symbol">()</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> </span><span class="string">" components"</span><span class="symbol">);</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="cbracket">}</span>
</tt></pre>

<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-10811519-2");
pageTracker._trackPageview();
} catch(err) {}</script>

</body>

<p><br><address><small>
Copyright &copy; 2002&ndash;2010, Robert Sedgewick and Kevin Wayne.
<br>Last updated: Sun Oct 27 02:13:49 EDT 2013.
</small></address>

</html>
